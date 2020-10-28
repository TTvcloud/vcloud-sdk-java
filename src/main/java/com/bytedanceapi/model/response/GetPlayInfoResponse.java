package com.bytedanceapi.model.response;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class GetPlayInfoResponse {

    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    private PlayResult result;

    @Data
    public static class PlayResult {
        @JSONField(name = "Vid")
        private String videoID;
        @JSONField(name = "Status")
        private Long status;
        @JSONField(name = "PosterUrl")
        private String posterUrl;
        @JSONField(name = "Duration")
        private Float duration;
        @JSONField(name = "FileType")
        private String mediaType;
        @JSONField(name = "TotalCount")
        private Integer totalCount;
        @JSONField(name = "EnableAdaptive")
        private Boolean enableAdaptive;
        @JSONField(name = "PlayInfoList")
        private List<PlayInfoList> playInfoList;
    }

    @Data
    public static class PlayInfoList {
        @JSONField(name = "Bitrate")
        private Float bitrate;
        @JSONField(name = "Encrypt")
        private Long encrypt;
        @JSONField(name = "Md5")
        private String fileHash;
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
        @JSONField(name = "LogoType")
        private String logoType;
        @JSONField(name = "Definition")
        private String definition;
        @JSONField(name = "Quality")
        private String quality;
        @JSONField(name = "PlayAuth")
        private String playAuth;
        @JSONField(name = "PlayAuthID")
        private String playAuthID;

        @JSONField(name = "MainPlayUrl")
        private String mainPlayUrl;
        @JSONField(name = "BackupPlayUrl")
        private String backupPlayUrl;
        @JSONField(name = "FileID")
        private String fileID;
        @JSONField(name = "FileType")
        private String fileType;
        @JSONField(name = "P2pVerifyUrl")
        private String p2pVerifyURL;
        @JSONField(name = "PreloadInterval")
        private Long preloadInterval;
        @JSONField(name = "PreloadMaxStep")
        private Long preloadMaxStep;
        @JSONField(name = "PreloadMinStep")
        private Long preloadMinStep;
        @JSONField(name = "PreloadSize")
        private Long preloadSize;
        @JSONField(name = "InitRange")
        private String initRange;
        @JSONField(name = "IndexRange")
        private String indexRange;
        @JSONField(name = "CheckInfo")
        private String checkInfo;

    }
}
