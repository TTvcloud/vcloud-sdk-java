package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.GetVideoInfosRequest;
import com.bytedanceapi.model.common.GetVideoInfosResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetVideoInfosDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTZDg4ZDlhOTBhYjQxNDdkOTg3MjQwYTQyNDA2NGZiZGU");
        vodService.setSecretKey("j1BGQboVi5502ri5FQytZadS3cPrnvescrWyC/rUDD/h+RHUvf4wpkrKmrUqIzsA");
        vodService.setHost("staging-openapi-boe.byted.org");

        String[] vids = new String[]{"v0c80e6a0000bu02dp6bajs8e253r6k0", "vid2", "vid3"};
        GetVideoInfosRequest.Builder req = GetVideoInfosRequest.newBuilder();
        List<String> vidList = Arrays.asList(vids);
        req.addAllVids(vidList);

        try {
            GetVideoInfosResponse resp = vodService.getVideoInfos(req.build());
            System.out.println(resp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
