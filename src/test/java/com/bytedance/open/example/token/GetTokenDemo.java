package com.bytedance.open.example.token;

import java.util.HashMap;
import java.util.Map;

public class GetTokenDemo {

    public static void main(String[] args) {
        com.bytedance.open.service.vod.VodService vodService = com.bytedance.open.service.vod.impl.VodServiceImpl.getInstance();

        String vid = "your vid";

        Map<String, String> query = new HashMap<String, String>();
        query.put("video_id", vid);

        try {
            String ret = vodService.getPlayAuthToken(query);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String space = "your space";
            String ret = vodService.getUploadAuthToken(space);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
