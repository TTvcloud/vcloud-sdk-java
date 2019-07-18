package com.bytedanceapi.model.response;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class GetPlayInfoResponse {

    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    private PlayResult Result;

    @Data
    public static class PlayResult {
        private PlayData Data;
    }

    @Data
    public static class PlayData {
        private int Status;
        private String VideoID;
        private String CoverUrl;
        private int Duration;
        private String MediaType;
        private int TotalCount;
        private List<PlayInfoList> PlayInfoList;
    }

    @Data
    public static class PlayInfoList {
        private int Bitrate;
        private boolean Encrypt;
        private String FileHash;
        private int Size;
        private int Height;
        private int Width;
        private String Format;
        private String Codec;
        private String Logo;
        private String Definition;
        private String Quality;
        private String PlayAuth;
        private String MainPlayUrl;
        private String BackupPlayUrl;
        private String FileID;
        private String P2pVerifyURL;
        private int PreloadInterval;
        private int PreloadMaxStep;
        private int PreloadMinStep;
        private int PreloadSize;
    }
}
