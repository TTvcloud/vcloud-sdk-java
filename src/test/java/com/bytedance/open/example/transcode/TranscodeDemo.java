package com.bytedance.open.example.transcode;

import com.bytedance.open.service.vod.VodService;
import com.bytedance.open.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;


public class TranscodeDemo {

    public static void main(String[] args) {
        VodService vodService = VodServiceImpl.getInstance();

//        vodService.setAccessKey("your ak");
//        vodService.setSecretKey("your sk");

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("watermark_str", "test");

        com.bytedance.open.model.vod.StartTranscodeRequest req = new com.bytedance.open.model.vod.StartTranscodeRequest();
        req.setVid("your vid");
        req.setTemplateId("your template id");
        req.setInput(input);
        req.setPriority(0);

        try {
            com.bytedance.open.model.vod.StartTranscodeResp resp = vodService.startTranscode(req);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
            }
            System.out.println(resp.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
