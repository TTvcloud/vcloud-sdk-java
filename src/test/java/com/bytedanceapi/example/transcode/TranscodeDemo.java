package com.bytedanceapi.example.transcode;

import com.bytedanceapi.model.request.StartWorkflowRequest;
import com.bytedanceapi.model.response.StartWorkflowResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;


public class TranscodeDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vid = "your vid";
        String templateId = "template Id";

        StartWorkflowRequest req = new StartWorkflowRequest();
        req.setVid(vid);
        req.setTemplateId(templateId);
        req.setPriority(0);

        try {
            StartWorkflowResponse resp = vodService.startWorkflow(req);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
