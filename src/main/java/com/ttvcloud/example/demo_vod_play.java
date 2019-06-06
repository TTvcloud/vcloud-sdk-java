package com.ttvcloud.example;

import com.ttvcloud.model.vod.GetPlayInfoResp;
import com.ttvcloud.model.vod.VodResponse;
import com.ttvcloud.service.vod.VodService;
import com.ttvcloud.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class demo_vod_play {

    public static void main(String[] args) {
        VodService vodService = VodServiceImpl.getInstance();

        Map<String, String> query = new HashMap<String, String>();
        query.put("video_id", "your vid");

        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        VodResponse response = vodService.getPlayInfo(query);
        if (response.getCode() == 0){
            GetPlayInfoResp getPlayInfoResp = (GetPlayInfoResp) response.getResp();
            System.out.println(getPlayInfoResp);
        } else {
            System.out.println(response);
        }
    }
}
