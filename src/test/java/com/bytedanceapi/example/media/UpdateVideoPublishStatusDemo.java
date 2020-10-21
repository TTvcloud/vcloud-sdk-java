package com.bytedanceapi.example.media;

import com.bytedanceapi.model.request.UpdateVideoPublishStatusRequest;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        //vodService.setAccessKey("");
        //vodService.setSecretKey("");

        String vid = "your vid";
        String statusPublished = "Published";
        String statusUnpublished = "Unpublished";

        try {
            // publish
            UpdateVideoPublishStatusRequest publishReq = new UpdateVideoPublishStatusRequest();
            publishReq.setVid(vid);
            publishReq.setStatus(statusPublished);
            vodService.updateVideoPublishStatus(publishReq);
            System.out.println("update video publish status success");

            Thread.sleep(2000);

            UpdateVideoPublishStatusRequest unpublishReq = new UpdateVideoPublishStatusRequest();
            unpublishReq.setVid(vid);
            unpublishReq.setStatus(statusUnpublished);
            vodService.updateVideoPublishStatus(unpublishReq);
            System.out.println("update video unpublish status success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
