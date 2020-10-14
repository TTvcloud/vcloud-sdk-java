package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Map;

@Data
public class CommitUploadInfoResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    DataBean dataBean;

    @Data
    public static class CommitUploadResultBean {
        @JSONField(name = "Vid")
        String vid;
        @JSONField(name = "SourceInfo")
        SourceInfoBean sourceInfo;
        @JSONField(name = "Encryption")
        EncryptionBean encryption;
        @JSONField(name = "PosterUri")
        String posterUri;
        @JSONField(name = "CallbackArgs")
        String callbackArgs;
    }

    @Data
    public static class DataBean {
        @JSONField(name = "Data")
        CommitUploadResultBean result;
    }


    @Data
    public static class SourceInfoBean {
        @JSONField(name = "StoreUri")
        String storeUri;
        @JSONField(name = "Md5")
        String md5;
        @JSONField(name = "Width")
        int width;
        @JSONField(name = "Height")
        int height;
        @JSONField(name = "Duration")
        float duration;
        @JSONField(name = "Bitrate")
        int bitrate;
        @JSONField(name = "Format")
        String format;
        @JSONField(name = "Size")
        int size;
        @JSONField(name = "FileType")
        String fileType;
    }

    @Data
    public static class ImageMetaBean {
        @JSONField(name = "Uri")
        String uri;
        @JSONField(name = "Height")
        int height;
        @JSONField(name = "Width")
        int width;
        @JSONField(name = "Md5")
        String md5;
    }

    @Data
    public static class ObjectMetaBean {
        @JSONField(name = "Uri")
        String uri;
        @JSONField(name = "Md5")
        String md5;
    }

    @Data
    public static class EncryptionBean {
        @JSONField(name = "Uri")
        String uri;
        @JSONField(name = "SecretKey")
        String secretKey;
        @JSONField(name = "Algorithm")
        String algorithm;
        @JSONField(name = "Version")
        String version;
        @JSONField(name = "SourceMd5")
        String sourceMd5;
        @JSONField(name = "Extra")
        Map<String, String> extra;
    }
}
