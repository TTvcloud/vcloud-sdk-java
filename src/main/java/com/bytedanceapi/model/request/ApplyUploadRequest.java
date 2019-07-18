package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ApplyUploadRequest {
    @JSONField(name = "SpaceName")
    String spaceName;
    @JSONField(name = "SessionKey")
    String sessionKey;
    @JSONField(name = "FileType")
    String fileType;
    @JSONField(name = "FileSize")
    Integer fileSize;
    @JSONField(name = "UploadNum")
    Integer uploadNum;
}
