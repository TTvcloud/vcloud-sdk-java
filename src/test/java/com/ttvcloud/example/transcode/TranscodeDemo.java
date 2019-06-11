package com.ttvcloud.example.transcode;

import com.ttvcloud.model.vod.StartTranscodeRequest;
import com.ttvcloud.model.vod.StartTranscodeResp;
import com.ttvcloud.model.vod.VodResponse;
import com.ttvcloud.service.vod.VodService;
import com.ttvcloud.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;


public class TranscodeDemo {

    public static void main(String[] args) {
        VodService vodService = VodServiceImpl.getInstance();

//        vodService.setAccessKey("your ak");
//        vodService.setSecretKey("your sk");

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("watermark_str", "test");

        StartTranscodeRequest req = new StartTranscodeRequest();
        req.setVid("your vid");
        req.setTemplateId("your template id");
        req.setInput(input);
        req.setPriority(0);

        VodResponse vodResponse = vodService.startTranscode(req);
        if (vodResponse.getCode() == 0) {
            StartTranscodeResp sTranscodeResp = (StartTranscodeResp) vodResponse.getResp();
            if (sTranscodeResp.getResponseMetadata().getError() != null) {
                System.out.println(sTranscodeResp.getResponseMetadata().getError());
            }
            System.out.println(sTranscodeResp.getResult());
        } else {
            System.out.println(vodResponse);
        }
    }
}
