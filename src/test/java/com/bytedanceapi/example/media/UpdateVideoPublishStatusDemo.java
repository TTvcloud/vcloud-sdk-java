package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.UpdateVideoPublishStatusRequest;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTZDg4ZDlhOTBhYjQxNDdkOTg3MjQwYTQyNDA2NGZiZGU");
        vodService.setSecretKey("j1BGQboVi5502ri5FQytZadS3cPrnvescrWyC/rUDD/h+RHUvf4wpkrKmrUqIzsA");
        vodService.setHost("staging-openapi-boe.byted.org");

        String vid = "v0c80e6a0000bu02dp6bajs8e253r6k0";
        String statusPublished = "Published";
        String statusUnpublished = "Unpublished";

        try {
            // publish
            UpdateVideoPublishStatusRequest.Builder publishReq = UpdateVideoPublishStatusRequest.newBuilder();
            publishReq.setVid(vid);
            publishReq.setStatus(statusPublished);
            System.out.println(vodService.updateVideoPublishStatus(publishReq.build()).toString());
            System.out.println("update video publish status success");

            Thread.sleep(2000);

            UpdateVideoPublishStatusRequest.Builder unpublishReq = UpdateVideoPublishStatusRequest.newBuilder();
            unpublishReq.setVid(vid);
            unpublishReq.setStatus(statusUnpublished);
            System.out.println(vodService.updateVideoPublishStatus(unpublishReq.build()).toString());
            System.out.println("update video unpublish status success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
