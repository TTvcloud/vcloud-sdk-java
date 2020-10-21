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
    static class Result {
        @JSONField(name = "Data")
        DataBean data;
    }

    @Data
    static class DataBean {
        @JSONField(name = "VideoInfoList")
        List<String> videoInfoList;
        @JSONField(name = "NotExistJobIds")
        List<String> notExistJobIds;
    }

    @Data
    static class VideoInfo{
            String requestId;
    }
}
