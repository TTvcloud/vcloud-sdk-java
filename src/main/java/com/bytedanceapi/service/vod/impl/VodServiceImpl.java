package com.bytedanceapi.service.vod.impl;

import com.google.gson.Gson;
import com.bytedanceapi.service.BaseVcloudService;
import com.bytedanceapi.service.vod.Config;
import com.bytedanceapi.service.vod.VodService;

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
    public com.bytedanceapi.model.vod.GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception {

        com.bytedanceapi.model.SdkResponse response = query("GetPlayInfo", query);
        if (response.getCode() != 0) {
            throw response.getException();
        }

        com.bytedanceapi.model.vod.GetPlayInfoResp getPlayInfoResp = gson.fromJson(new String(response.getData()), com.bytedanceapi.model.vod.GetPlayInfoResp.class);
        getPlayInfoResp.getResponseMetadata().setService("vod");

        return getPlayInfoResp;

    }


    @Override
    public String getPlayAuthToken(Map<String, String> query) throws Exception {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("Version", "v1");

        String getPlayInfoToken = getSignUrl("GetPlayInfo", query);
        ret.put("GetPlayInfoToken", getPlayInfoToken);

        String retStr = gson.toJson(ret);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(retStr.getBytes());
    }

    @Override
    public com.bytedanceapi.model.vod.StartTranscodeResp startTranscode(com.bytedanceapi.model.vod.StartTranscodeRequest req) throws Exception {
        Map<String, String> query = new HashMap<String, String>();
        query.put("TemplateId", req.getTemplateId());

        com.bytedanceapi.model.vod.TranscodeRequestBody reqBody = new com.bytedanceapi.model.vod.TranscodeRequestBody();
        reqBody.setVid(req.getVid());
        reqBody.setInput(req.getInput());
        reqBody.setPriority(req.getPriority());

        String body = gson.toJson(reqBody);

        com.bytedanceapi.model.SdkResponse resp = json("StartTranscode", query, body);
        if (resp.getCode() != 0) {
            throw resp.getException();
        }

        return gson.fromJson(new String(resp.getData()), com.bytedanceapi.model.vod.StartTranscodeResp.class);
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
