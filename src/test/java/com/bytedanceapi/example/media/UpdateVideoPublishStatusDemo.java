package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.request.VodUpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.vod.response.VodUpdateVideoPublishStatusResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vid1 = "vid1";
        String vid2 = "vid2";
        String statusPublished = "Published";
        String statusUnpublished = "Unpublished";

        try {
            // publish
            VodUpdateVideoPublishStatusRequest.Builder req = VodUpdateVideoPublishStatusRequest.newBuilder();
            req.setVid(vid1);
            req.setStatus(statusPublished);

            VodUpdateVideoPublishStatusResponse resp = vodService.updateVideoPublishStatus(req.build());
            System.out.println(resp);

            Thread.sleep(1000);

            // unpublish
            VodUpdateVideoPublishStatusRequest.Builder req1 = VodUpdateVideoPublishStatusRequest.newBuilder();
            req1.setVid(vid2);
            req1.setStatus(statusUnpublished);

            VodUpdateVideoPublishStatusResponse resp1 = vodService.updateVideoPublishStatus(req1.build());
            System.out.println(resp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
