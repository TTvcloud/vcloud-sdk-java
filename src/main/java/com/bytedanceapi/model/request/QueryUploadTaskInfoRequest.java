package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class QueryUploadTaskInfoRequest {
    @JSONField(name = "JobIds")
    private String jobIds;
}
