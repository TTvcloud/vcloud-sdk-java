package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class GetPlayInfoRequest {
    @JSONField(name = "Vid")
    String videoId;
    @JSONField(name = "Format")
    String formatType;
    @JSONField(name = "Codec")
    String codecType;
    @JSONField(name = "Definition")
    String definition;
    @JSONField(name = "StreamType")
    String streamType;
    @JSONField(name = "Watermark")
    String watermark;
    @JSONField(name = "Base64")
    Long base64;
    @JSONField(name = "Ssl")
    Long ssl;
}
