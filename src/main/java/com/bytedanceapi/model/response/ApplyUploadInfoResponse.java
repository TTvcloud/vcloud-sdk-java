package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class ApplyUploadInfoResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    UploadResult result;

    @Data
    public static class UploadAddressBean {
        @JSONField(name = "UploadHeader")
        private UploadHeaderBean uploadHeader;
        @JSONField(name = "SessionKey")
        private String sessionKey;
        @JSONField(name = "StoreInfos")
        private List<StoreInfosBean> storeInfos;
        @JSONField(name = "UploadHosts")
        private List<String> uploadHosts;
    }

    @Data
    public static class UploadHeaderBean {
    }


    @Data
    public static class StoreInfosBean {
        @JSONField(name = "StoreUri")
        private String storeUri;
        @JSONField(name = "Auth")
        private String auth;
    }

    @Data
    public static class UploadResult {
        @JSONField(name = "Data")
        private DataBean data;
    }

    @Data
    public static class DataBean {
        @JSONField(name = "UploadAddress")
        private UploadAddressBean uploadAddress;
    }
}
