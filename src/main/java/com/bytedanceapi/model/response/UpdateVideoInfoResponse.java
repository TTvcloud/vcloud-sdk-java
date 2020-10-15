package com.bytedanceapi.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdateVideoInfoResponse {
    @JSONField(name = "ResponseMetadata")
    ResponseMetadata responseMetadata;
}
