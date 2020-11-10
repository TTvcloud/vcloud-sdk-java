package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.request.VodGetVideoInfosRequest;
import com.bytedanceapi.model.vod.response.VodGetVideoInfosResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetVideoInfosDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vids = "vid1,vid2,vid3";

        try {
            VodGetVideoInfosRequest.Builder req = VodGetVideoInfosRequest.newBuilder();
            req.setVids(vids);

            VodGetVideoInfosResponse resp = vodService.getVideoInfos(req.build());
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
