package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class ApplyUploadResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    UploadResult result;

    @Data
    public static class UploadAddressBean {
        private UploadHeaderBean UploadHeader;
        private String SessionKey;
        private AdvanceOptionBean AdvanceOption;
        private List<StoreInfosBean> StoreInfos;
        private List<String> UploadHosts;
    }

    @Data
    public static class UploadHeaderBean {
    }

    @Data
    public static class AdvanceOptionBean {
        private int Parallel;
        private int Stream;
        private int SliceSize;
    }

    @Data
    public static class StoreInfosBean {
        private String StoreUri;
        private String Auth;
    }

    @Data
    public class UploadResult {
        @JSONField(name = "UploadAddress")
        private UploadAddressBean uploadAddress;
        private String RequestId;
    }
}
