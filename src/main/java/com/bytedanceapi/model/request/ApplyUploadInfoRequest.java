package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ApplyUploadInfoRequest {
    @JSONField(name = "SpaceName")
    String spaceName;
    @JSONField(name = "SessionKey")
    String sessionKey;
    @JSONField(name = "FileSize")
    Integer fileSize;
}
