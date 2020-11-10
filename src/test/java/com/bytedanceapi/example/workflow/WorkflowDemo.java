package com.bytedanceapi.example.workflow;

import com.bytedanceapi.model.vod.request.VodStartWorkflowRequest;
import com.bytedanceapi.model.vod.response.VodStartWorkflowResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;


public class WorkflowDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vid = "your vid";
        String templateId = "template Id";

        // 1. get play info
        try {
            VodStartWorkflowRequest.Builder reqBuilder = VodStartWorkflowRequest.newBuilder();
            reqBuilder.setVid(vid);
            reqBuilder.setTemplateId(templateId);

            VodStartWorkflowResponse resp = vodService.startWorkflow(reqBuilder.build());
            if (resp.getResponseMetadata().hasError()) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getResult().getRunId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
