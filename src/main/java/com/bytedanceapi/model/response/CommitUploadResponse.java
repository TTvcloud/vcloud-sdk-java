package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CommitUploadResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    CommitUploadResultBean result;

    @Data
    public static class CommitUploadResultBean {
        String RequestId;
        List<UploadResultBean> Results;
    }

    @Data
    public static class UploadResultBean {
        String Vid;
        VideoMetaBean VideoMeta;
        ImageMetaBean ImageMeta;
        ObjectMetaBean ObjectMeta;
        EncryptionBean Encryption;
        String SnapshotUri;
    }

    @Data
    public static class VideoMetaBean {
        String Uri;
        int Height;
        int Width;
        float Duration;
        int Bitrate;
        String Md5;
        String Format;
        int Size;
    }

    @Data
    public static class ImageMetaBean {
        String Uri;
        int Height;
        int Width;
        String Md5;
    }

    @Data
    public static class ObjectMetaBean {
        String Uri;
        String Md5;
    }

    @Data
    public static class EncryptionBean {
        String Uri;
        String SecretKey;
        String Algorithm;
        String Version;
        String SourceMd5;
        Map<String, String> Extra;
    }
}
