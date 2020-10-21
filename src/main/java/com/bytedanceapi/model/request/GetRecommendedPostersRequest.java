package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class GetRecommendedPostersRequest {
    @JSONField(name = "Vids")
    String[] vids;
}
