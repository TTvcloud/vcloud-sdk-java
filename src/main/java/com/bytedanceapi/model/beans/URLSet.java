package com.bytedanceapi.model.beans;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class URLSet {
    @JSONField(name = "SourceUrl")
    String SourceUrl;
    @JSONField(name = "CallbackArgs")
    String CallbackArgs;
    @JSONField(name = "Md5")
    String Md5;
    @JSONField(name = "TemplateId")
    String TemplateId;
    @JSONField(name = "Title")
    String Title;
    @JSONField(name = "Description")
    String Description;
    @JSONField(name = "Tags")
    String Tags;
}
