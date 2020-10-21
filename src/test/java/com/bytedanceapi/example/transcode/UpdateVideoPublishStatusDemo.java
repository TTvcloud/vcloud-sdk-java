package com.bytedanceapi.example.transcode;

import com.bytedanceapi.model.request.UpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.response.UpdateVideoPublishStatusResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String spaceName = "your spaceName";
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

            Thread.sleep(20000);

            UpdateVideoPublishStatusRequest unpublishReq = new UpdateVideoPublishStatusRequest();
            unpublishReq.setVid(vid);
            unpublishReq.setStatus(statusUnpublished);
            vodService.updateVideoPublishStatus(unpublishReq);
            System.out.println("update video publish status success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
