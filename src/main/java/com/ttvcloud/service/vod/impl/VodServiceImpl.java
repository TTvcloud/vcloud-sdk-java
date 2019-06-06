package com.ttvcloud.service.vod.impl;

import com.google.gson.Gson;
import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.vod.GetPlayInfoResp;
import com.ttvcloud.model.vod.VodResponse;
import com.ttvcloud.service.BaseVcloudService;
import com.ttvcloud.service.vod.Config;
import com.ttvcloud.service.vod.VodService;
import com.ttvcloud.util.Utils;

import java.util.Map;

public class VodServiceImpl extends BaseVcloudService implements VodService {

    private Gson gson = new Gson();

    private VodServiceImpl(){
        super(Config.serviceInfo, Config.apiInfoList);
    }

    public static VodService getInstance() {

        return new VodServiceImpl();
    }

    public VodResponse getPlayInfo(Map<String, String> query) {

        SdkResponse response = query("GetPlayInfo", Utils.mapToPairList(query));
        if (response.getCode() != 0) {
            return new VodResponse(response.getCode(), null, response.getException());
        }
        try {
            GetPlayInfoResp getPlayInfoResp = gson.fromJson(new String(response.getData()), GetPlayInfoResp.class);
            getPlayInfoResp.getResponseMetadata().setService("vod");

            return new VodResponse(0, getPlayInfoResp,null);
        } catch (Exception e) {
            return new VodResponse(500, e, null);
        }

    }


}
