package com.bytedanceapi.example.media;

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
            vodService.updateVideoPublishStatus(vid, statusPublished);
            System.out.println("update video publish status success");

            Thread.sleep(2000);

            vodService.updateVideoPublishStatus(vid, statusUnpublished);
            System.out.println("update video unpublish status success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
