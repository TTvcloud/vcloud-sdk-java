package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class GetVideoInfosResponse {
    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    private GetVideoInfosResp result;

    @Data
    public static class GetVideoInfosResp {
        @JSONField(name = "VideoInfoList")
        private List<VideoInfo> VideoInfoList;
        @JSONField(name = "NotExistVids")
        private String[] NotExistVids;
    }

    @Data
    public static class VideoInfo {
        @JSONField(name = "BasicInfo")
        private BasicInfo BasicInfo;
        @JSONField(name = "SourceInfo")
        private SourceInfo SourceInfo;
        @JSONField(name = "TranscodeInfo")
        private TranscodeInfo TranscodeInfo;
    }

    @Data
    public static class BasicInfo {
        @JSONField(name = "SpaceName")
        private String SpaceName;
        @JSONField(name = "Vid")
        private String Vid;
        @JSONField(name = "Title")
        private String Title;
        @JSONField(name = "Description")
        private String Description;
        @JSONField(name = "PosterUri")
        private String PosterUri;
        @JSONField(name = "PublishStatus")
        private String PublishStatus;
        @JSONField(name = "AuditStatus")
        private int AuditStatus;
        @JSONField(name = "Tags")
        private String[] Tags;
        @JSONField(name = "CreateTime")
        private String CreateTime;
    }

    @Data
    public static class SourceInfo {
        @JSONField(name = "FileId")
        private String FileId;
        @JSONField(name = "Md5")
        private String Md5;
        @JSONField(name = "FileType")
        private String FileType;
        @JSONField(name = "Codec")
        private String Codec;
        @JSONField(name = "Height")
        private int Height;
        @JSONField(name = "Width")
        private int Width;
        @JSONField(name = "Format")
        private String Format;
        @JSONField(name = "Duration")
        private double Duration;
        @JSONField(name = "Size")
        private int Size;
        @JSONField(name = "StoreUri")
        private String StoreUri;
        @JSONField(name = "Definition")
        private String Definition;
        @JSONField(name = "Bitrate")
        private int Bitrate;
        @JSONField(name = "Fps")
        private double Fps;
        @JSONField(name = "CreateTime")
        private String CreateTime;
    }

    @Data
    public static class TranscodeInfo {
        @JSONField(name = "FileId")
        private String FileId;
        @JSONField(name = "Md5")
        private String Md5;
        @JSONField(name = "FileType")
        private String FileType;
        @JSONField(name = "LogoType")
        private String LogoType;
        @JSONField(name = "Encrypt")
        private boolean Encrypt;
        @JSONField(name = "Format")
        private String Format;
        @JSONField(name = "Duration")
        private double Duration;
        @JSONField(name = "Size")
        private int Size;
        @JSONField(name = "StoreUri")
        private String StoreUri;
        @JSONField(name = "VideoStreamMeta")
        private VideoStreamMeta VideoStreamMeta;
        @JSONField(name = "AudioStreamMeta")
        private AudioStreamMeta AudioStreamMeta;
        @JSONField(name = "CreateTime")
        private String CreateTime;
    }

    @Data
    public static class VideoStreamMeta {
        @JSONField(name = "Codec")
        private String Codec;
        @JSONField(name = "Height")
        private int Height;
        @JSONField(name = "Width")
        private int Width;
        @JSONField(name = "Duration")
        private double Duration;
        @JSONField(name = "Definition")
        private String Definition;
        @JSONField(name = "Bitrate")
        private int Bitrate;
        @JSONField(name = "Fps")
        private double Fps;
    }

    @Data
    public static class AudioStreamMeta {
        @JSONField(name = "Codec")
        private String Codec;
        @JSONField(name = "Duration")
        private double Duration;
        @JSONField(name = "SampleRate")
        private int SampleRate;
        @JSONField(name = "Bitrate")
        private int Bitrate;
    }
}
