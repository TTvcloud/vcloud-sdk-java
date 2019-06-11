package com.ttvcloud.example.token;

import com.ttvcloud.service.vod.VodService;
import com.ttvcloud.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class GetTokenDemo {

    public static void main(String[] args) {
        VodService vodService = VodServiceImpl.getInstance();

        String vid = "your vid";

        Map<String, String> query = new HashMap<String, String>();
        query.put("video_id", vid);

        try {
            String ret = vodService.getPlayAuthToken(query);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
