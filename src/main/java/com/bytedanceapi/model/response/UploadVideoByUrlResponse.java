package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class UploadVideoByUrlResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    DataBean result;

    @Data
    static class DataBean {
        @JSONField(name = "Data")
        private List<ValuePair> valuePairs;
    }

    @Data
    static class ValuePair {
        @JSONField(name = "SourceUrl")
        private String sourceUrl;
        @JSONField(name = "JobId")
        private String jobId;
    }

}


