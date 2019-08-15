package com.bytedanceapi.service.vod.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedanceapi.error.SdkError;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.helper.Utils;
import com.bytedanceapi.model.beans.*;
import com.bytedanceapi.model.request.*;
import com.bytedanceapi.model.response.*;
import com.bytedanceapi.service.BaseServiceImpl;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.VodConfig;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        super(VodConfig.serviceInfo, VodConfig.apiInfoList);
    }

    public static IVodService getInstance() {
        return new VodServiceImpl();
    }

    @Override
    public GetSpaceResponse getSpace(GetSpaceRequest getSpaceRequest) throws Exception {
        RawResponse response = query(Const.GetSpace, Utils.paramsToMap(getSpaceRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetSpaceResponse getSpaceResponse = JSON.parseObject(response.getData(), GetSpaceResponse.class);
        getSpaceResponse.getResponseMetadata().setService("vod");
        return getSpaceResponse;
    }

    @Override
    public GetPlayInfoResponse getPlayInfo(GetPlayInfoRequest getPlayInfoRequest) throws Exception {
        RawResponse response = query(Const.GetPlayInfo, Utils.paramsToMap(getPlayInfoRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetPlayInfoResponse getPlayInfoResp = JSON.parseObject(response.getData(), GetPlayInfoResponse.class);
        getPlayInfoResp.getResponseMetadata().setService("vod");
        return getPlayInfoResp;
    }

    @Override
    public String getPlayAuthToken(Map<String, String> params) throws Exception {
        Map<String, String> ret = new HashMap<>();
        ret.put("Version", "v1");
        String getPlayInfoToken = getSignUrl(Const.GetPlayInfo, params);
        ret.put("GetPlayInfoToken", getPlayInfoToken);

        String retStr = JSON.toJSONString(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public GetOriginVideoPlayResponse getOriginVideoPlayInfo(GetOriginVideoPlayRequest getOriginVideoPlayRequest) throws Exception {
        RawResponse response = query(Const.GetOriginVideoPlayInfo, Utils.paramsToMap(getOriginVideoPlayRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        GetOriginVideoPlayResponse getOriginVideoPlayResponse = JSON.parseObject(response.getData(), GetOriginVideoPlayResponse.class);
        getOriginVideoPlayResponse.getResponseMetadata().setService("vod");
        return getOriginVideoPlayResponse;
    }

    @Override
    public String getRedirectPlay(GetRedirectPlayRequest getRedirectPlayRequest) throws Exception {
        String uri = getSignUrl(Const.RedirectPlay, Utils.paramsToMap(getRedirectPlayRequest));
        String proto = "http";
        String host = serviceInfo.getHost();
        return String.format("%s://%s/?%s", proto, host, uri);
    }

    @Override
    public StartTranscodeResponse startTranscode(StartTranscodeRequest startTranscodeRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("TemplateId", startTranscodeRequest.getTemplateId());

        StartTranscodeRequestBody startTranscodeRequestBody = new StartTranscodeRequestBody();
        startTranscodeRequestBody.setVid(startTranscodeRequest.getVid());
        startTranscodeRequestBody.setInput(startTranscodeRequest.getInput());
        startTranscodeRequestBody.setPriority(startTranscodeRequest.getPriority());

        RawResponse resp = json(Const.StartTranscode, params, JSON.toJSONString(startTranscodeRequestBody));
        if (resp.getCode() != SdkError.SUCCESS.getNumber()) {
            throw resp.getException();
        }

        return JSON.parseObject(resp.getData(), StartTranscodeResponse.class);
    }

    @Override
    public SetVideoPublishStatusResponse setVideoPublishStatus(SetVideoPublishStatusRequest setVideoPublishStatusRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        RawResponse resp = json(Const.SetVideoPublishStatus, params, JSON.toJSONString(setVideoPublishStatusRequest));
        if (resp.getCode() != SdkError.SUCCESS.getNumber()) {
            throw resp.getException();
        }

        return JSON.parseObject(resp.getData(), SetVideoPublishStatusResponse.class);
    }

    @Override
    public GetDomainWeightsResponse getDomainWeights(String spaceName) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.SpaceName, spaceName);

        RawResponse response = query(Const.GetCdnDomainWeights, params);
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

        String applyUploadToken = getSignUrl(Const.ApplyUpload, params);
        ret.put("ApplyUploadToken", applyUploadToken);

        String commitUploadToken = getSignUrl(Const.CommitUpload, params);
        ret.put("CommitUploadToken", commitUploadToken);

        String retStr = JSON.toJSONString(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public ApplyUploadResponse applyUpload(ApplyUploadRequest applyUploadRequest) throws Exception {
        RawResponse response = query(Const.ApplyUpload, Utils.paramsToMap(applyUploadRequest));
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

        RawResponse response = json(Const.CommitUpload, params, JSON.toJSONString(commitUploadRequestBody));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        CommitUploadResponse commitUploadResponse = JSON.parseObject(response.getData(), CommitUploadResponse.class);
        commitUploadResponse.getResponseMetadata().setService("vod");
        return commitUploadResponse;
    }

    @Override
    public UploadMediaByUrlResponse uploadMediaByUrl(UploadMediaByUrlRequest uploadMediaByUrlRequest) throws Exception {
        RawResponse response = query(Const.UploadMediaByUrl, Utils.paramsToMap(uploadMediaByUrlRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }

        UploadMediaByUrlResponse uploadMediaByUrlResponse = JSON.parseObject(response.getData(), UploadMediaByUrlResponse.class);
        uploadMediaByUrlResponse.getResponseMetadata().setService("vod");
        return uploadMediaByUrlResponse;
    }

    @Override
    public ModifyVideoInfoResponse modifyVideoInfo(ModifyVideoInfoRequest modifyVideoInfoRequest) throws Exception {
        Map<String, String> params = new HashMap<>();
        RawResponse response = json(Const.ModifyVideoInfo, params, JSON.toJSONString(modifyVideoInfoRequest));
        if (response.getCode() != SdkError.SUCCESS.getNumber()) {
            throw response.getException();
        }
        ModifyVideoInfoResponse modifyVideoInfoResponse = JSON.parseObject(response.getData(), ModifyVideoInfoResponse.class);
        modifyVideoInfoResponse.getResponseMetadata().setService("vod");
        return modifyVideoInfoResponse;
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

        ModifyVideoInfoRequest modifyVideoInfoRequest = new ModifyVideoInfoRequest();
        modifyVideoInfoRequest.setSpaceName(spaceName);
        modifyVideoInfoRequest.setVid(vid);
        ModifyVideoInfoRequest.UserMetaInfo userMetaInfo = new ModifyVideoInfoRequest.UserMetaInfo();
        userMetaInfo.setPosterUri(oid);
        modifyVideoInfoRequest.setInfo(userMetaInfo);

        ModifyVideoInfoResponse modifyVideoInfoResponse = modifyVideoInfo(modifyVideoInfoRequest);
        if (modifyVideoInfoResponse.getResponseMetadata().getError() != null) {
            throw new Exception(modifyVideoInfoResponse.getResponseMetadata().getError().getMessage());
        }
        if (modifyVideoInfoResponse.getResult() == null || modifyVideoInfoResponse.getResult().getBaseResp() == null || modifyVideoInfoResponse.getResult().getBaseResp().getStatusCode() != 0) {
            throw new Exception("modify poster error" + modifyVideoInfoResponse.getResult().getBaseResp().getStatusMessage());
        }
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

}
