package com.bytedanceapi.service.vod.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedanceapi.error.SdkError;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.helper.Utils;
import com.bytedanceapi.model.ServiceInfo;
import com.bytedanceapi.model.beans.*;
import com.bytedanceapi.model.common.*;
import com.bytedanceapi.model.common.GetRecommendedPostersRequest;
import com.bytedanceapi.model.common.GetRecPostersResponse;
import com.bytedanceapi.model.common.GetVideoInfosRequest;
import com.bytedanceapi.model.common.GetVideoInfosResponse;
import com.bytedanceapi.model.common.UpdateVideoInfoRequest;
import com.bytedanceapi.model.common.UpdateVideoInfoResponse;
import com.bytedanceapi.model.common.UpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.common.UpdateVideoPublishStatusResponse;
import com.bytedanceapi.model.request.*;
import com.bytedanceapi.model.response.*;
import com.bytedanceapi.model.sts2.Policy;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.model.sts2.Statement;
import com.bytedanceapi.service.BaseServiceImpl;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.VodConfig;
import com.bytedanceapi.util.Sts2Utils;
import com.bytedanceapi.util.Time;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.JsonFormat;
import org.apache.http.NameValuePair;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VodServiceImpl extends BaseServiceImpl implements IVodService {

    private static final int UPDATE_INTERVAL = 10;
    private Map<String, Map<String, Integer>> domainCache = new HashMap<>();
    private Map<String, Integer> fallbackDomainWeights;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ScheduledThreadPoolExecutor scheduledExecutorService = new ScheduledThreadPoolExecutor(5);

    private VodServiceImpl() {
        super(VodConfig.ServiceInfoMap.get(Const.REGION_CN_NORTH_1), VodConfig.apiInfoList);
    }

    private VodServiceImpl(ServiceInfo serviceInfo) {
        super(serviceInfo, VodConfig.apiInfoList);
    }

    public static IVodService getInstance() {
        return new VodServiceImpl();
    }

    public static IVodService getInstance(String region) throws Exception {
        ServiceInfo serviceInfo = VodConfig.ServiceInfoMap.get(region);
        if (serviceInfo == null) {
            throw new Exception("Cant find the region, please check it carefully");
        }
        return new VodServiceImpl(serviceInfo);
    }


    @Override
    public GetSpaceResponse getSpace(GetSpaceRequest getSpaceRequest) throws Exception {
        RawResponse response = query(Const.GetSpace, Utils.mapToPairList(Utils.paramsToMap(getSpaceRequest)));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetSpaceResponse getSpaceResponse = JSON.parseObject(response.getData(), GetSpaceResponse.class);
        getSpaceResponse.getResponseMetadata().setService("vod");
        return getSpaceResponse;
    }

    @Override
    public VodGetPlayInfoResponse getPlayInfo(VodGetPlayInfoRequest getPlayInfoRequest) throws Exception {
        RawResponse response = query(Const.GetPlayInfo, Utils.mapToPairList(Utils.paramsToMap(getPlayInfoRequest)));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        VodGetPlayInfoResponse.Builder responseBuilder = VodGetPlayInfoResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

    @Override
    public String getPlayAuthToken(Map<String, String> params) throws Exception {
        Map<String, String> ret = new HashMap<>();
        ret.put("Version", "v1");
        String getPlayInfoToken = getSignUrl(Const.GetPlayInfo, Utils.mapToPairList(params));
        ret.put("GetPlayInfoToken", getPlayInfoToken);

        String retStr = JSON.toJSONString(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public VodGetOriginalPlayInfoResponse getOriginVideoPlayInfo(VodGetOriginalPlayInfoRequest getOriginVideoPlayRequest) throws Exception {
        RawResponse response = query(Const.GetOriginVideoPlayInfo, Utils.mapToPairList(Utils.paramsToMap(getOriginVideoPlayRequest)));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        VodGetOriginalPlayInfoResponse.Builder responseBuilder = VodGetOriginalPlayInfoResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

//    @Override
//    public String getRedirectPlay(GetRedirectPlayRequest getRedirectPlayRequest) throws Exception {
//        String uri = getSignUrl(Const.RedirectPlay, Utils.mapToPairList(Utils.paramsToMap(getRedirectPlayRequest)));
//        String proto = "http";
//        String host = serviceInfo.getHost();
//        return String.format("%s://%s/?%s", proto, host, uri);
//    }

    @Override
    public StartWorkflowResponse startWorkflow(StartWorkflowRequest startWorkflowRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("TemplateId", startWorkflowRequest.getTemplateId());
        params.put("Vid", startWorkflowRequest.getVid());
        params.put("Priority", Integer.toString(startWorkflowRequest.getPriority()));
        String inputStr = JSON.toJSONString(startWorkflowRequest.getInput());
        params.put("Input", inputStr);
        params.put("CallbackArgs", startWorkflowRequest.getCallbackArgs());

        RawResponse resp = post(Const.StartWorkflow, new ArrayList<NameValuePair>(), Utils.mapToPairList(params));
        if (resp.getCode() != SdkError.SUCCESS.getNumber()) {
            throw resp.getException();
        }

        return JSON.parseObject(resp.getData(), StartWorkflowResponse.class);
    }

    @Override
    public UpdateVideoPublishStatusResponse updateVideoPublishStatus(UpdateVideoPublishStatusRequest req) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put(Const.Vid, req.getVid());
        params.put(Const.Status, req.getStatus());
        RawResponse response = query(Const.UpdateVideoPublishStatus, Utils.mapToPairList(params));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        UpdateVideoPublishStatusResponse.Builder responseBuilder = UpdateVideoPublishStatusResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

    @Override
    public GetDomainWeightsResponse getDomainWeights(String spaceName) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.SpaceName, spaceName);

        RawResponse response = query(Const.GetCdnDomainWeights, Utils.mapToPairList(params));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            return null;
        }

        GetDomainWeightsResponse getDomainWeightsResponse = JSON.parseObject(response.getData(), GetDomainWeightsResponse.class);
        if (getDomainWeightsResponse.getResponseMetadata().getError() != null) {
            return getDomainWeightsResponse;
        }
        Map<String, Map<String, Integer>> resMap = new HashMap<>();
        JSONObject jsonObject = JSON.parseObject(getDomainWeightsResponse.getResult());

        for (Map.Entry<String, String> entry : params.entrySet()) {
            Map<String, Integer> innerMap = new HashMap<>();
            if (!jsonObject.containsKey(entry.getValue()) && entry.getKey().equals(Const.SpaceName)) {
                resMap.put(entry.getValue(), innerMap);
                continue;
            }
            JSONObject obj = jsonObject.getJSONObject(entry.getValue());
            for (Map.Entry<String, Object> e : obj.entrySet()) {
                innerMap.put(e.getKey(), Integer.parseInt(e.getValue().toString()));
            }

            resMap.put(entry.getValue(), innerMap);
        }
        getDomainWeightsResponse.setResultMap(resMap);
        getDomainWeightsResponse.getResponseMetadata().setService("vod");
        return getDomainWeightsResponse;
    }

    @Override
    public void setFallbackDomainWeights(Map<String, Integer> fallbackDomainWeights) {
        if (fallbackDomainWeights != null) {
            this.fallbackDomainWeights = fallbackDomainWeights;
        }
    }

    @Override
    public void shutdown() {
        this.scheduledExecutorService.shutdown();
    }

    @Override
    public DomainInfo getDomainInfo(String spaceName) {
        reentrantReadWriteLock.readLock().lock();
        if (!this.domainCache.containsKey(spaceName)) {
            reentrantReadWriteLock.readLock().unlock();

            reentrantReadWriteLock.writeLock().lock();
            if (!this.domainCache.containsKey(spaceName)) {
                Map<String, Integer> weightsMap;
                try {
                    GetDomainWeightsResponse getDomainWeightsResponse = getDomainWeights(spaceName);
                    weightsMap = getDomainWeightsResponse.getResultMap().get(spaceName);
                } catch (Exception e) {
                    // fallback
                    weightsMap = this.fallbackDomainWeights;
                }
                this.domainCache.put(spaceName, weightsMap);
                reentrantReadWriteLock.writeLock().unlock();

                AsyncGetDomainWeightsTask asyncGetDomainWeightsTask = new AsyncGetDomainWeightsTask(spaceName, this);
                this.scheduledExecutorService.scheduleWithFixedDelay(asyncGetDomainWeightsTask, UPDATE_INTERVAL, UPDATE_INTERVAL, TimeUnit.SECONDS);
            } else {
                reentrantReadWriteLock.writeLock().unlock();
            }
        } else {
            reentrantReadWriteLock.readLock().unlock();
        }

        Map<String, Integer> cache = this.domainCache.get(spaceName);

        DomainInfo domainInfo = new DomainInfo();
        String mainDomain = Utils.randWeights(cache, "");
        String backupDomain = Utils.randWeights(cache, mainDomain);
        domainInfo.setMainDomain(mainDomain);
        domainInfo.setBackupDomain(backupDomain);
        return domainInfo;
    }

    @Override
    public ImgUrl getPosterUrl(String spaceName, String uri, ImgUrlOption imgUrlOption) {
        DomainInfo domainInfo = getDomainInfo(spaceName);
        String proto = Const.HTTP;
        if (imgUrlOption.isHttps()) {
            proto = Const.HTTPS;
        }
        String format = Const.FORMAT_ORIGINAL;
        if (imgUrlOption.getFomat() != null) {
            format = imgUrlOption.getFomat();
        }
        String tpl = Const.VOD_TPL_NOOP;
        if (imgUrlOption.getTpl() != null) {
            tpl = imgUrlOption.getTpl();
        }
        if (tpl == Const.VOD_TPL_OBJ || tpl == Const.VOD_TPL_NOOP) {
            tpl = imgUrlOption.getTpl();
        } else {
            tpl = String.format("%s:%d:%d", imgUrlOption.getTpl(), imgUrlOption.getW(), imgUrlOption.getH());
        }

        ImgUrl imgUrl = new ImgUrl();
        imgUrl.setMainUrl(String.format("%s://%s/%s~%s.%s", proto, domainInfo.getMainDomain(), uri, tpl, format));
        imgUrl.setBackupUrl(String.format("%s://%s/%s~%s.%s", proto, domainInfo.getBackupDomain(), uri, tpl, format));
        return imgUrl;
    }

    @Override
    public String getUploadAuthToken(Map<String, String> params) throws Exception {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("Version", "v1");
        List<NameValuePair> pairs = Utils.mapToPairList(params);

        String applyUploadToken = getSignUrl(Const.ApplyUpload, pairs);
        ret.put("ApplyUploadToken", applyUploadToken);

        String commitUploadToken = getSignUrl(Const.CommitUpload, pairs);
        ret.put("CommitUploadToken", commitUploadToken);

        String retStr = JSON.toJSONString(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public ApplyUploadResponse applyUpload(ApplyUploadRequest applyUploadRequest) throws Exception {
        RawResponse response = query(Const.ApplyUpload, Utils.mapToPairList(Utils.paramsToMap(applyUploadRequest)));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        ApplyUploadResponse applyUploadResponse = JSON.parseObject(response.getData(), ApplyUploadResponse.class);
        applyUploadResponse.getResponseMetadata().setService("vod");
        return applyUploadResponse;
    }

    @Override
    public CommitUploadResponse commitUpload(CommitUploadRequest commitUploadRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put(Const.SpaceName, commitUploadRequest.getSpaceName());

        CommitUploadRequestBody commitUploadRequestBody = new CommitUploadRequestBody();
        commitUploadRequestBody.setCallbackArgs(commitUploadRequest.getCallbackArgs());
        commitUploadRequestBody.setFunctions(commitUploadRequest.getFunctions());
        commitUploadRequestBody.setSessionKey(commitUploadRequest.getSessionKey());

        RawResponse response = json(Const.CommitUpload, Utils.mapToPairList(params), JSON.toJSONString(commitUploadRequestBody));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        CommitUploadResponse commitUploadResponse = JSON.parseObject(response.getData(), CommitUploadResponse.class);
        commitUploadResponse.getResponseMetadata().setService("vod");
        return commitUploadResponse;
    }

    @Override
    public UploadMediaByUrlResponse uploadMediaByUrl(UploadMediaByUrlRequest uploadMediaByUrlRequest) throws Exception {
        RawResponse response = query(Const.UploadMediaByUrl, Utils.mapToPairList(Utils.paramsToMap(uploadMediaByUrlRequest)));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        UploadMediaByUrlResponse uploadMediaByUrlResponse = JSON.parseObject(response.getData(), UploadMediaByUrlResponse.class);
        uploadMediaByUrlResponse.getResponseMetadata().setService("vod");
        return uploadMediaByUrlResponse;
    }

//    @Override
//    public void updateVideoInfo(UpdateVideoInfoRequest req) throws Exception {
//        Map<String, String> params = new HashMap<>();
//        params.put(Const.Vid, req.getVid());
//        if(req.hasPosterUri()){
//            params.put(Const.PosterUri, req.getPosterUri().getValue());
//        }
//        if(req.hasTitle()){
//            params.put(Const.Title, req.getTitle().getValue());
//        }
//        if(req.hasDescription()){
//            params.put(Const.Description, req.getDescription().getValue());
//        }
//        if(req.hasTags()){
//            params.put(Const.Tags, req.getTags().getValue());
//        }
//
//        RawResponse response = query(Const.UpdateVideoInfo, Utils.mapToPairList(params));
//        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
//            throw response.getException();
//        }
//
//        UpdateVideoInfoResponse.Builder responseBuilder = UpdateVideoInfoResponse.newBuilder();
//        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
//        if(responseBuilder.getResponseMetadata().getError() != null){
//            throw new Exception("update video info error " + responseBuilder.getResponseMetadata().getError().getMessage());
//        }
//    }

    /**
     * updateVideoInfo.
     *
     * @param input com.bytedanceapi.model.common.UpdateVideoInfoRequest
     * @return com.bytedanceapi.model.common.UpdateVideoInfoResponse
     * @throws Exception the exception
     */
    @Override
    public UpdateVideoInfoResponse updateVideoInfo(UpdateVideoInfoRequest input) throws Exception {
        String jsonString = JsonFormat.printer().includingDefaultValueFields().print(input);
        Map<String, Object> jm = JSONObject.toJavaObject(JSONObject.parseObject(jsonString), Map.class);
        Map<String, String> params = new HashMap<>();

        RawResponse response = query(Const.UpdateVideoInfo, Utils.mapToPairList(params));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        UpdateVideoInfoResponse.Builder responseBuilder = UpdateVideoInfoResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

    @Override
    public GetVideoInfosResponse getVideoInfos(GetVideoInfosRequest req) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put(Const.Vids, String.join(",", req.getVidsList()));
        RawResponse response = query(Const.GetVideoInfos, Utils.mapToPairList(params));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetVideoInfosResponse.Builder responseBuilder = GetVideoInfosResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

    @Override
    public GetRecPostersResponse getRecommendedPosters(GetRecommendedPostersRequest req) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put(Const.Vids, String.join(",", req.getVidsList()));
        RawResponse response = query(Const.GetRecommendedPoster, Utils.mapToPairList(params));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetRecPostersResponse.Builder responseBuilder = GetRecPostersResponse.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(new InputStreamReader(new ByteArrayInputStream(response.getData())), responseBuilder);
        return responseBuilder.build();
    }

    private UploadCompleteInfo upload(String spaceName, String filePath, String fileType) throws Exception {
        File file = new File(filePath);
        if (!(file.isFile() && file.exists())) {
            throw new Exception(SdkError.getErrorDesc(SdkError.ENOFILE));
        }
        long crc32 = Utils.crc32(filePath);
        if (crc32 == -1) {
            throw new Exception("file crc32 error");
        }
        String checkSum = String.format("%x", crc32);

        ApplyUploadRequest applyUploadRequest = new ApplyUploadRequest();
        applyUploadRequest.setSpaceName(spaceName);
        applyUploadRequest.setFileType(fileType);

        // apply upload
        ApplyUploadResponse applyUploadResponse = applyUpload(applyUploadRequest);
        if (applyUploadResponse.getResponseMetadata().getError() != null) {
            throw new Exception(applyUploadResponse.getResponseMetadata().getError().getMessage());
        }
        if (applyUploadResponse.getResult() == null || applyUploadResponse.getResult().getUploadAddress().getStoreInfos() == null) {
            throw new Exception("apply upload result is null");
        }

        String oid = applyUploadResponse.getResult().getUploadAddress().getStoreInfos().get(0).getStoreUri();
        String sessionKey = applyUploadResponse.getResult().getUploadAddress().getSessionKey();
        String auth = applyUploadResponse.getResult().getUploadAddress().getStoreInfos().get(0).getAuth();
        String host = applyUploadResponse.getResult().getUploadAddress().getUploadHosts().get(0);
        String url = String.format("http://%s/%s", host, oid);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-CRC32", checkSum);
        headers.put("Authorization", auth);

        long startTime = System.currentTimeMillis();
        boolean uploadStatus = false;
        for (int i = 0; i < 3; i++) {
            uploadStatus = put(url, filePath, headers);
            if (uploadStatus) {
                break;
            }
        }
        if (!uploadStatus) {
            throw new Exception(SdkError.getErrorDesc(SdkError.EUPLOAD));
        }
        long endTime = System.currentTimeMillis();
        long cost = endTime - startTime;
        float avgSpeed = (float) file.length() / (float) cost;
        System.out.println(String.format("upload {%s} cost {%d} ms, avgSpeed: {%f} KB/s", filePath, cost, avgSpeed));

        UploadCompleteInfo uploadCompleteInfo = new UploadCompleteInfo(oid, sessionKey);
        return uploadCompleteInfo;
    }

    @Override
    public CommitUploadResponse uploadVideo(String spaceName, String filePath, String fileType, List<Functions> functions) throws Exception {
        UploadCompleteInfo uploadCompleteInfo = upload(spaceName, filePath, fileType);

        CommitUploadRequest commitUploadRequest = new CommitUploadRequest();
        commitUploadRequest.setCallbackArgs("");
        commitUploadRequest.setSessionKey(uploadCompleteInfo.getSessionKey());
        commitUploadRequest.setFunctions(functions);
        commitUploadRequest.setSpaceName(spaceName);

        // commit upload
        CommitUploadResponse commitUploadResponse = commitUpload(commitUploadRequest);
        if (commitUploadResponse.getResponseMetadata().getError() != null) {
            throw new Exception(commitUploadResponse.getResponseMetadata().getError().getMessage());
        }
        return commitUploadResponse;
    }

    @Override
    public String uploadPoster(String vid, String spaceName, String filePath, String fileType) throws Exception {
        UploadCompleteInfo uploadCompleteInfo = upload(spaceName, filePath, fileType);
        String oid = uploadCompleteInfo.getOid();

        UpdateVideoInfoRequest.Builder req = UpdateVideoInfoRequest.newBuilder();
        req.setVid(vid);
        req.setPosterUri(StringValue.of(oid));

        updateVideoInfo(req.build());

        return oid;
    }

    private static class AsyncGetDomainWeightsTask implements Runnable {
        private String spaceName;
        private VodServiceImpl vodService;

        public AsyncGetDomainWeightsTask(String spaceName, VodServiceImpl vodService) {
            this.spaceName = spaceName;
            this.vodService = vodService;
        }

        @Override
        public void run() {
            Map<String, Integer> weightsMap;

            try {
                GetDomainWeightsResponse getDomainWeightsResponse = this.vodService.getDomainWeights(spaceName);
                weightsMap = getDomainWeightsResponse.getResultMap().get(spaceName);
            } catch (Exception e) {
                // fallback
                weightsMap = this.vodService.fallbackDomainWeights;
            }

            this.vodService.reentrantReadWriteLock.writeLock().lock();
            this.vodService.domainCache.put(spaceName, weightsMap);
            this.vodService.reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public SecurityToken2 getVideoPlayAuthWithExpiredTime(List<String> vidList, List<String> streamTypeList, List<String> watermarkList, long expiredTime) throws Exception {
        Policy inlinePolicy = new Policy();
        List<String> actions = new ArrayList<>();
        actions.add(VodConfig.ACTION_GET_PLAY_INFO);
        List<String> resources = new ArrayList<>();

        // 设置vid的resource权限
        addResourceFormat(vidList, resources, VodConfig.RESOURCE_VIDEO_FORMAT);

        // 设置streamType的resource权限
        addResourceFormat(streamTypeList, resources, VodConfig.RESOURCE_STREAM_TYPE_FORMAT);

        // 设置watermark的resource权限
        addResourceFormat(watermarkList, resources, VodConfig.RESOURCE_WATERMARK_FORMAT);

        Statement statement = Sts2Utils.newAllowStatement(actions, resources);
        inlinePolicy.addStatement(statement);
        return signSts2(inlinePolicy, expiredTime);
    }

    private void addResourceFormat(List<String> list, List<String> resources, String resourceFormat) {
        if (list.size() == 0)
            resources.add(String.format(resourceFormat, VodConfig.STAR));
        else
            list.forEach(value -> resources.add(String.format(resourceFormat, value)));
    }

    public SecurityToken2 getVideoPlayAuth(List<String> vidList, List<String> streamTypeList, List<String> watermarkList) throws Exception {
        return getVideoPlayAuthWithExpiredTime(vidList, streamTypeList, watermarkList, Time.Hour);
    }

}
