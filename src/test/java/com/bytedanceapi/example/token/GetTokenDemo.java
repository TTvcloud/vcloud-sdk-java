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

        try {
            String vid = "your vid";
            Map<String, String> params = new HashMap<String, String>();
            params.put("video_id", vid);
            // set expires time of the play auth token, defalut is 15min(900),
            // set if if you know the params' meaning exactly.
            params.put("X-Amz-Expires", "60");

            String ret = vodService.getPlayAuthToken(params);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String spaceName = "your space";
            Map<String, String> params = new HashMap<String, String>();
            params.put("SpaceName", spaceName);
            // set expires time of the upload token, defalut is 15min(900),
            // set if if you know the params' meaning exactly.
            params.put("X-Amz-Expires", "60");
            String ret = vodService.getUploadAuthToken(params);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
