package com.ttvcloud.service.vod.impl;

import com.google.gson.Gson;
import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.vod.*;
import com.ttvcloud.service.BaseVcloudService;
import com.ttvcloud.service.vod.Config;
import com.ttvcloud.service.vod.VodService;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class VodServiceImpl extends BaseVcloudService implements VodService {

    private Gson gson = new Gson();

    private VodServiceImpl(){
        super(Config.serviceInfo, Config.apiInfoList);
    }

    public static VodService getInstance() {

        return new VodServiceImpl();
    }

    @Override
    public GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception {

        SdkResponse response = query("GetPlayInfo", query);
        if (response.getCode() != 0) {
            throw response.getException();
        }

        GetPlayInfoResp getPlayInfoResp = gson.fromJson(new String(response.getData()), GetPlayInfoResp.class);
        getPlayInfoResp.getResponseMetadata().setService("vod");

        return getPlayInfoResp;

    }


    @Override
    public String getPlayAuthToken(Map<String, String> query) throws Exception {
        return getSignUrl("GetPlayInfo", query);
    }

    @Override
    public StartTranscodeResp startTranscode(StartTranscodeRequest req) throws Exception {
        Map<String, String> query = new HashMap<String, String>();
        query.put("TemplateId", req.getTemplateId());

        TranscodeRequestBody reqBody = new TranscodeRequestBody();
        reqBody.setVid(req.getVid());
        reqBody.setInput(req.getInput());
        reqBody.setPriority(req.getPriority());

        String body = gson.toJson(reqBody);

        SdkResponse resp = json("StartTranscode", query, body);
        if (resp.getCode() != 0) {
            throw resp.getException();
        }

        return gson.fromJson(new String(resp.getData()), StartTranscodeResp.class);
    }

    @Override
    public String getUploadAuthToken(String space) throws Exception{
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("Version", "v1");

        Map<String, String> query = new HashMap<String, String>();
        query.put("SpaceName", space);

        String applyUploadToken = getSignUrl("ApplyUpload", query);
        ret.put("ApplyUploadToken", applyUploadToken);

        String commitUploadToken = getSignUrl("CommitUpload", query);
        ret.put("CommitUploadToken", commitUploadToken);

        String retStr = gson.toJson(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

}
