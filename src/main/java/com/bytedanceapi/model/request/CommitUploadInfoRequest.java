package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CommitUploadInfoRequest {
    @JSONField(name = "SpaceName")
    String spaceName;
    @JSONField(name = "CallbackArgs")
    String callbackArgs;
    @JSONField(name = "SessionKey")
    String sessionKey;
    @JSONField(name = "Functions")
    String functions;
}
