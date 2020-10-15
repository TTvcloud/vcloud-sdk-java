package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdateVideoPublishStatusRequest {
    @JSONField(name = "Vid")
    String vid;
    @JSONField(name = "Status")
    String status;
}
