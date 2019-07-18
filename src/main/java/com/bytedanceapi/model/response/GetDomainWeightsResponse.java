package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Map;

@Data
public class GetDomainWeightsResponse {
    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
    private String Result;
    private Map<String, Map<String, Integer>> ResultMap;
}
