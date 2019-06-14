package com.bytedanceapi.example.token;

import java.util.HashMap;
import java.util.Map;

public class GetTokenDemo {

    public static void main(String[] args) {
        com.bytedanceapi.service.vod.VodService vodService = com.bytedanceapi.service.vod.impl.VodServiceImpl.getInstance();

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
