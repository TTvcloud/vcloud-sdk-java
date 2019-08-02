package com.bytedanceapi.example.transcode;

import com.bytedanceapi.model.request.StartTranscodeRequest;
import com.bytedanceapi.model.response.StartTranscodeResponse;
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

        StartTranscodeRequest req = new StartTranscodeRequest();
        req.setVid(vid);
        req.setTemplateId(templateId);
        req.setPriority(0);

        try {
            StartTranscodeResponse resp = vodService.startTranscode(req);
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
