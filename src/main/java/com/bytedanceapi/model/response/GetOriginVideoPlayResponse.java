package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class GetOriginVideoPlayResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    OriginPlayData originPlayData;

    @Data
    public static class OriginPlayData {
        private String MediaType;
        private double Duration;
        private int Size;
        private int Height;
        private int Width;
        private String Format;
        private String Codec;
        private int Bitrate;
        private String FileHash;
        private String MainPlayUrl;
        private String BackupPlayUrl;
    }
}
