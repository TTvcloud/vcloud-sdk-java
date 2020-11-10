package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.request.VodUpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.vod.response.VodUpdateVideoPublishStatusResponse;
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
            VodUpdateVideoPublishStatusRequest.Builder publishReq = VodUpdateVideoPublishStatusRequest.newBuilder();
            publishReq.setVid(vid);
            publishReq.setStatus(statusPublished);
            VodUpdateVideoPublishStatusResponse resp = vodService.updateVideoPublishStatus(publishReq.build());
            if(resp.getResponseMetadata().hasError()){
                System.out.println("update video publish status error: " + resp.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp.toString());
            System.out.println("update video publish status to publish success");

            Thread.sleep(500);

            VodUpdateVideoPublishStatusRequest.Builder unpublishReq = VodUpdateVideoPublishStatusRequest.newBuilder();
            unpublishReq.setVid(vid);
            unpublishReq.setStatus(statusUnpublished);
            VodUpdateVideoPublishStatusResponse resp1 = vodService.updateVideoPublishStatus(unpublishReq.build());
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
