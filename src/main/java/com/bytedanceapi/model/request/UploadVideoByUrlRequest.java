package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


@Data
public class UploadVideoByUrlRequest {
    @JSONField(name = "SpaceName")
    String spaceName;
    @JSONField(name = "URLSets")
    String URLSets;
}
