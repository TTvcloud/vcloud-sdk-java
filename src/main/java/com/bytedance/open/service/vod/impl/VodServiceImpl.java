package com.bytedance.open.service.vod.impl;

import com.google.gson.Gson;
import com.bytedance.open.service.BaseVcloudService;
import com.bytedance.open.service.vod.Config;
import com.bytedance.open.service.vod.VodService;

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
    public com.bytedance.open.model.vod.GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception {

        com.bytedance.open.model.SdkResponse response = query("GetPlayInfo", query);
        if (response.getCode() != 0) {
            throw response.getException();
        }

        com.bytedance.open.model.vod.GetPlayInfoResp getPlayInfoResp = gson.fromJson(new String(response.getData()), com.bytedance.open.model.vod.GetPlayInfoResp.class);
        getPlayInfoResp.getResponseMetadata().setService("vod");

        return getPlayInfoResp;

    }


    @Override
    public String getPlayAuthToken(Map<String, String> query) throws Exception {
        return getSignUrl("GetPlayInfo", query);
    }

    @Override
    public com.bytedance.open.model.vod.StartTranscodeResp startTranscode(com.bytedance.open.model.vod.StartTranscodeRequest req) throws Exception {
        Map<String, String> query = new HashMap<String, String>();
        query.put("TemplateId", req.getTemplateId());

        com.bytedance.open.model.vod.TranscodeRequestBody reqBody = new com.bytedance.open.model.vod.TranscodeRequestBody();
        reqBody.setVid(req.getVid());
        reqBody.setInput(req.getInput());
        reqBody.setPriority(req.getPriority());

        String body = gson.toJson(reqBody);

        com.bytedance.open.model.SdkResponse resp = json("StartTranscode", query, body);
        if (resp.getCode() != 0) {
            throw resp.getException();
        }

        return gson.fromJson(new String(resp.getData()), com.bytedance.open.model.vod.StartTranscodeResp.class);
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
