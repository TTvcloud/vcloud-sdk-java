package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdateVideoPublishStatusResponse {
    @JSONField(name = "ResponseMetadata")
    private ResponseMetadata responseMetadata;
}
