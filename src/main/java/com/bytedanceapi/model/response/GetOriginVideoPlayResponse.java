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
        @JSONField(name = "FileType")
        private String mediaType;
        @JSONField(name = "Duration")
        private Float duration;
        @JSONField(name = "Size")
        private Long size;
        @JSONField(name = "Height")
        private Long height;
        @JSONField(name = "Width")
        private Long width;
        @JSONField(name = "Format")
        private String format;
        @JSONField(name = "Codec")
        private String codec;
        @JSONField(name = "Bitrate")
        private Float bitrate;
        @JSONField(name = "Md5")
        private String fileHash;
        @JSONField(name = "MainPlayUrl")
        private String mainPlayUrl;
        @JSONField(name = "BackupPlayUrl")
        private String backupPlayUrl;
    }
}
