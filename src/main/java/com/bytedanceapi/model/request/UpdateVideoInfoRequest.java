package com.bytedanceapi.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdateVideoInfoRequest {
    @JSONField(name = "Vid")
    String vid;
    @JSONField(name = "PosterUri")
    String posterUri;
    @JSONField(name = "Title")
    String title;
    @JSONField(name = "Description")
    String description;
    @JSONField(name = "Tags")
    String tags;

    public UpdateVideoInfoRequest(){
        this.posterUri = null;
        this.title = null;
        this.description = null;
        this.tags = null;
    }
}
