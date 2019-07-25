package com.bytedanceapi.example.token;

import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class GetTokenDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vid = "your vid";

        Map<String, String> params = new HashMap<String, String>();
        params.put("video_id", vid);

        try {
            String ret = vodService.getPlayAuthToken(params);
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
