package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GetRecommendedPostersResponse {
    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    @JSONField(name = "Result")
    private GetRecommendedPostersResp result;

    @Data
    public static class GetRecommendedPostersResp {
        @JSONField(name = "StoreUriGroups")
        private Map<String, String[]> StoreUriGroups;
        @JSONField(name = "NotExistVids")
        private String[] NotExistVids;
    }
}
