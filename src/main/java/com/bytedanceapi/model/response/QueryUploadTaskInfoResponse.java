package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class QueryUploadTaskInfoResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    Result result;

    @Data
    public static class Result {
        @JSONField(name = "Data")
        DataBean data;
    }

    @Data
    public static class DataBean {
        @JSONField(name = "VideoInfoList")
        List<VideoInfo> videoInfoList;
        @JSONField(name = "NotExistJobIds")
        List<String> notExistJobIds;
    }

    @Data
    public static class VideoInfo {
        @JSONField(name = "RequestId")
        String requestId;
        @JSONField(name = "JobId")
        String jobId;
        @JSONField(name = "SourceUrl")
        String sourceUrl;
        @JSONField(name = "State")
        String state;
        @JSONField(name = "Vid")
        String vid;
        @JSONField(name = "SpaceName")
        String spaceName;
        @JSONField(name = "AccountId")
        String accountId;
        @JSONField(name = "SourceInfo")
        CommitUploadInfoResponse.SourceInfoBean sourceInfo;
    }
}
