package com.bytedanceapi.example.workflow;

import com.bytedanceapi.model.request.SetVideoPublishStatusRequest;
import com.bytedanceapi.model.response.SetVideoPublishStatusResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class SetVideoPublishStatusDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String spaceName = "your spaceName";
        String vid = "your vid";
        String statusPublished = "Published";
        String statusBlocked = "Blocked";

        try {
            SetVideoPublishStatusRequest setVideoPublishStatusRequest = new SetVideoPublishStatusRequest();
            setVideoPublishStatusRequest.setSpaceName(spaceName);
            setVideoPublishStatusRequest.setVid(vid);
            setVideoPublishStatusRequest.setStatus(statusPublished);

            // publish
            SetVideoPublishStatusResponse resp = vodService.setVideoPublishStatus(setVideoPublishStatusRequest);
            System.out.println(resp);

            Thread.sleep(20000);

            // block
            setVideoPublishStatusRequest.setStatus(statusBlocked);
            resp = vodService.setVideoPublishStatus(setVideoPublishStatusRequest);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
