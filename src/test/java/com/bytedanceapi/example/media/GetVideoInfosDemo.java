package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.request.VodGetVideoInfosRequest;
import com.bytedanceapi.model.vod.response.VodGetVideoInfosResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetVideoInfosDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        VodGetVideoInfosRequest.Builder req = VodGetVideoInfosRequest.newBuilder();
        req.setVids("vid1,vid2,vid3");

        try {
            VodGetVideoInfosResponse resp = vodService.getVideoInfos(req.build());
            if(resp.getResponseMetadata().hasError()){
                System.out.println("get video infos error: " + resp.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
