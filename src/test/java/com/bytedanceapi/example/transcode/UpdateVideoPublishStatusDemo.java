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
            vodService.updateVideoPublishStatus(vid, statusPublished);
            System.out.println("update video publish status success");

            Thread.sleep(20000);

            vodService.updateVideoPublishStatus(vid, statusUnpublished);
            System.out.println("update video publish status success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
