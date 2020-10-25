package com.bytedanceapi.service.imagex.impl;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.error.SdkError;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.helper.Utils;
import com.bytedanceapi.model.ServiceInfo;
import com.bytedanceapi.model.request.ApplyUploadRequest;
import com.bytedanceapi.model.request.CommitUploadRequest;
import com.bytedanceapi.model.request.CommitUploadRequestBody;
import com.bytedanceapi.model.request.DeleteImageReq;
import com.bytedanceapi.model.response.ApplyUploadResponse;
import com.bytedanceapi.model.response.CommitUploadResponse;
import com.bytedanceapi.model.response.DeleteImageResp;
import com.bytedanceapi.model.response.RawResponse;
import com.bytedanceapi.model.sts2.Policy;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.model.sts2.Statement;
import com.bytedanceapi.service.BaseServiceImpl;
import com.bytedanceapi.service.imagex.IImageXService;
import com.bytedanceapi.service.imagex.ImageXConfig;
import com.bytedanceapi.util.Sts2Utils;
import com.bytedanceapi.util.Time;
import org.apache.http.NameValuePair;

import java.util.*;
import java.util.zip.CRC32;

public class ImageXServiceImpl extends BaseServiceImpl implements IImageXService {

    private ImageXServiceImpl() {
        super(ImageXConfig.ServiceInfoMap.get(Const.REGION_CN_NORTH_1), ImageXConfig.apiInfoList);
    }

    private ImageXServiceImpl(ServiceInfo serviceInfo) {
        super(serviceInfo, ImageXConfig.apiInfoList);
    }

    public static IImageXService getInstance() {
        return new ImageXServiceImpl();
    }

    public static IImageXService getInstance(String region) throws Exception {
        ServiceInfo serviceInfo = ImageXConfig.ServiceInfoMap.get(region);
        if (serviceInfo == null) {
            throw new Exception("Can't find the region, please check it carefully");
        }
        return new ImageXServiceImpl(serviceInfo);
    }

    @Override
    public ApplyUploadResponse applyImageUpload(ApplyUploadRequest applyUploadRequest) throws Exception {
        RawResponse response = query("ApplyImageUpload", Utils.paramsToPair(applyUploadRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        ApplyUploadResponse applyUploadResponse = JSON.parseObject(response.getData(), ApplyUploadResponse.class);
        if (applyUploadResponse.getResponseMetadata().getError() != null) {
            throw new Exception(applyUploadResponse.getResponseMetadata().getError().getMessage());
        }
        applyUploadResponse.getResponseMetadata().setService("ImageX");
        return applyUploadResponse;
    }

    @Override
    public CommitUploadResponse commitImageUpload(CommitUploadRequest commitUploadRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("ServiceId", commitUploadRequest.getServiceId());
        if (commitUploadRequest.getSpaceName() != null) {
            params.put(Const.SpaceName, commitUploadRequest.getSpaceName());
        }
        CommitUploadRequestBody commitUploadRequestBody = new CommitUploadRequestBody();
        commitUploadRequestBody.setSessionKey(commitUploadRequest.getSessionKey());
        commitUploadRequestBody.setOptionInfos(commitUploadRequest.getOptionInfos());

        RawResponse response = json("CommitImageUpload", Utils.mapToPairList(params), JSON.toJSONString(commitUploadRequestBody));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        CommitUploadResponse commitUploadResponse = JSON.parseObject(response.getData(), CommitUploadResponse.class);
        if (commitUploadResponse.getResponseMetadata().getError() != null) {
            throw new Exception(commitUploadResponse.getResponseMetadata().getError().getMessage());
        }
        commitUploadResponse.getResponseMetadata().setService("ImageX");
        return commitUploadResponse;
    }

    private void doUpload(String host, ApplyUploadResponse.StoreInfosBean storeInfo, byte[] imageData) throws Exception {
        CRC32 crc = new CRC32();
        crc.update(imageData);
        if (crc.getValue() == -1) {
            throw new Exception("image data crc32 error");
        }
        String checkSum = String.format("%x", crc.getValue());
        String url = String.format("http://%s/%s", host, storeInfo.getStoreUri());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-CRC32", checkSum);
        headers.put("Authorization", storeInfo.getAuth());

        long startTime = System.currentTimeMillis();
        boolean uploadStatus = false;
        for (int i = 0; i < 3; i++) {
            uploadStatus = putData(url, imageData, headers);
            if (uploadStatus) {
                break;
            }
        }
        if (!uploadStatus) {
            throw new Exception(SdkError.getErrorDesc(SdkError.EUPLOAD));
        }
        long endTime = System.currentTimeMillis();
        long cost = endTime - startTime;
        float avgSpeed = (float) imageData.length / (float) cost;
        System.out.println(String.format("upload image cost {%d} ms, avgSpeed: {%f} KB/s", cost, avgSpeed));
    }

    @Override
    public CommitUploadResponse uploadImages(ApplyUploadRequest request, List<byte[]> imageDatas) throws Exception {
        if (imageDatas.size() == 0) {
            throw new Exception("empty image data");
        }
        request.setUploadNum(imageDatas.size());

        // apply upload
        ApplyUploadResponse applyUploadResponse = applyImageUpload(request);
        if (applyUploadResponse.getResult() == null) {
            throw new Exception("apply upload result is null");
        }
        ApplyUploadResponse.UploadAddressBean uploadAddr = applyUploadResponse.getResult().getUploadAddress();
        if (uploadAddr == null || uploadAddr.getUploadHosts() == null || uploadAddr.getUploadHosts().size() == 0) {
            throw new Exception("apply upload address is null");
        }
        List<ApplyUploadResponse.StoreInfosBean> storeInfos = uploadAddr.getStoreInfos();
        if (storeInfos.size() != imageDatas.size()) {
            throw new Exception("apply upload get wrong store infos");
        }
        String uploadHost = uploadAddr.getUploadHosts().get(0);
        String sessionKey = uploadAddr.getSessionKey();

        // upload
        for (int i = 0; i < imageDatas.size(); i++) {
            doUpload(uploadHost, storeInfos.get(i), imageDatas.get(i));
        }

        // commit upload
        CommitUploadRequest commitRequest = new CommitUploadRequest();
        commitRequest.setServiceId(request.getServiceId());
        commitRequest.setSpaceName(request.getSpaceName());
        commitRequest.setSessionKey(sessionKey);
        return commitImageUpload(commitRequest);
    }

    @Override
    public String getUploadToken(Map<String, String> params) throws Exception {
        Map<String, String> ret = new HashMap<>();
        ret.put("Version", "v1");

        List<NameValuePair> pairs = Utils.mapToPairList(params);
        String applyUploadToken = getSignUrl("ApplyImageUpload", pairs);
        ret.put("ApplyUploadToken", applyUploadToken);
        String commitUploadToken = getSignUrl("CommitImageUpload", pairs);
        ret.put("CommitUploadToken", commitUploadToken);

        String retStr = JSON.toJSONString(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public SecurityToken2 getUploadSts2(List<String> serviceIds) throws Exception {
        return getUploadSts2WithExpire(serviceIds, Time.Hour);
    }

    @Override
    public SecurityToken2 getUploadSts2WithExpire(List<String> serviceIds, long expire) throws Exception {
        Policy inlinePolicy = new Policy();
        List<String> actions = new ArrayList<>();
        actions.add("ImageX:ApplyImageUpload");
        actions.add("ImageX:CommitImageUpload");

        List<String> resources = new ArrayList<>();
        if (serviceIds.size() == 0)
            resources.add(String.format(ImageXConfig.RESOURCE_SERVICE_ID_FORMAT, "*"));
        else
            serviceIds.forEach(value -> resources.add(String.format(ImageXConfig.RESOURCE_SERVICE_ID_FORMAT, value)));

        Statement statement = Sts2Utils.newAllowStatement(actions, resources);
        inlinePolicy.addStatement(statement);
        return signSts2(inlinePolicy, expire);
    }

    @Override
    public DeleteImageResp deleteImages(DeleteImageReq req) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("ServiceId", req.getServiceId());

        RawResponse response = json("DeleteImageUploadFiles", Utils.mapToPairList(params), JSON.toJSONString(req));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        DeleteImageResp resp = JSON.parseObject(response.getData(), DeleteImageResp.class);
        if (resp.getResponseMetadata().getError() != null) {
            throw new Exception(resp.getResponseMetadata().getError().getMessage());
        }
        resp.getResponseMetadata().setService("ImageX");
        return resp;
    }
}
