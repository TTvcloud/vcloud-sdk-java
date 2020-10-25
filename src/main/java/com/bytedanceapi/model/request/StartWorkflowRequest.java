package com.bytedanceapi.model.request;

import lombok.Data;

import java.util.Map;

@Data
public class StartWorkflowRequest {

    private String Vid;
    private String TemplateId;
    private Map<String, Object> Input;
    private int Priority;
    private String CallbackArgs;
}
