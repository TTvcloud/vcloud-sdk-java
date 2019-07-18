package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class StartTranscodeResponse {

    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    private TranscodeResult Result;

    @Data
    public static class TranscodeResult {
        private String RunId;
    }
}
