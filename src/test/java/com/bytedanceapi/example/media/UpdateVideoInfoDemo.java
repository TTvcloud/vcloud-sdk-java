package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.UpdateVideoInfoRequest;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import com.google.protobuf.StringValue;

public class UpdateVideoInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
         vodService.setAccessKey("AKLTZDg4ZDlhOTBhYjQxNDdkOTg3MjQwYTQyNDA2NGZiZGU");
         vodService.setSecretKey("j1BGQboVi5502ri5FQytZadS3cPrnvescrWyC/rUDD/h+RHUvf4wpkrKmrUqIzsA");
         vodService.setHost("staging-openapi-boe.byted.org");

        String vid = "v0c80e6a0000bu02dp6bajs8e253r6k0";
        String title = "Publish";

        try {
            UpdateVideoInfoRequest.Builder req = UpdateVideoInfoRequest.newBuilder();
            req.setVid(vid);
            req.setTags(StringValue.of("fasdfa,fddff")); //置空
            req.setTitle(StringValue.of(title));
            System.out.println(vodService.updateVideoInfo(req.build()).toString());
            System.out.println("update video video success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
