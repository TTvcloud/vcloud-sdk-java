package com.ttvcloud.service.vod.impl;

import com.google.gson.Gson;
import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.vod.*;
import com.ttvcloud.service.BaseVcloudService;
import com.ttvcloud.service.vod.Config;
import com.ttvcloud.service.vod.VodService;

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
    public VodResponse getPlayInfo(Map<String, String> query) {

        SdkResponse response = query("GetPlayInfo", query);
        if (response.getCode() != 0) {
            return new VodResponse(response.getCode(), null, response.getException());
        }
        try {
            GetPlayInfoResp getPlayInfoResp = gson.fromJson(new String(response.getData()), GetPlayInfoResp.class);
            getPlayInfoResp.getResponseMetadata().setService("vod");

            return new VodResponse(0, getPlayInfoResp,null);
        } catch (Exception e) {
            return new VodResponse(500, null, e);
        }

    }


    @Override
    public String getPlayAuthToken(Map<String, String> query) throws Exception {
        return getSignUrl("GetPlayInfo", query);
    }

    @Override
    public VodResponse startTranscode(StartTranscodeRequest req) {
        Map<String, String> query = new HashMap<String, String>();
        query.put("TemplateId", req.getTemplateId());

        TranscodeRequestBody reqBody = new TranscodeRequestBody();
        reqBody.setVid(req.getVid());
        reqBody.setInput(req.getInput());
        reqBody.setPriority(req.getPriority());

        String body = gson.toJson(reqBody);

        SdkResponse resp = json("StartTranscode", query, body);
        if (resp.getCode() != 0) {
            return new VodResponse(resp.getCode(), null, resp.getException());
        }

        try {
            StartTranscodeResp transcodeResp = gson.fromJson(new String(resp.getData()), StartTranscodeResp.class);
            return new VodResponse(0, transcodeResp, null);
        } catch (Exception e) {
            return new VodResponse(500, null, e);
        }
    }
}
