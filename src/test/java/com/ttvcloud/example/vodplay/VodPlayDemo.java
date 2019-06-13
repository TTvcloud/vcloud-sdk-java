package com.ttvcloud.example.vodplay;

import com.ttvcloud.model.vod.GetPlayInfoResp;
import com.ttvcloud.service.vod.VodService;
import com.ttvcloud.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class VodPlayDemo {

    public static void main(String[] args) {
        VodService vodService = VodServiceImpl.getInstance();

        Map<String, String> query = new HashMap<String, String>();
        query.put("video_id", "your vid");

//        vodService.setAccessKey("your ak");
//        vodService.setSecretKey("your sk");
        try {
            GetPlayInfoResp resp = vodService.getPlayInfo(query);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
            }
            System.out.println(resp.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
