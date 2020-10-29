package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.UpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.common.UpdateVideoPublishStatusResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        String vid = "your vid";
        String statusPublished = "Published";
        String statusUnpublished = "Unpublished";

        try {
            // publish
//            UpdateVideoPublishStatusRequest.Builder publishReq = UpdateVideoPublishStatusRequest.newBuilder();
//            publishReq.setVid(vid);
//            publishReq.setStatus(statusPublished);
//            UpdateVideoPublishStatusResponse resp = vodService.updateVideoPublishStatus(publishReq.build());
//            if(resp.getResponseMetadata().hasError()){
//                System.out.println("update video publish status error: " + resp.getResponseMetadata().getError().getMessage());
//                return;
//            }
//            System.out.println(resp.toString());
//            System.out.println("update video publish status to publish success");
//
//            Thread.sleep(2000);

            UpdateVideoPublishStatusRequest.Builder unpublishReq = UpdateVideoPublishStatusRequest.newBuilder();
            unpublishReq.setVid(vid);
            unpublishReq.setStatus(statusUnpublished);
            UpdateVideoPublishStatusResponse resp1 = vodService.updateVideoPublishStatus(unpublishReq.build());
            if(resp1.getResponseMetadata().hasError()){
                System.out.println("update video publish status error: " + resp1.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp1.toString());
            System.out.println("update video publish status to unpublish success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
