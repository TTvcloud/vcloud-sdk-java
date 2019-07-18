package com.bytedanceapi.model.request;

import lombok.Data;

import java.util.Map;

@Data
public class StartTranscodeRequestBody {

    private String Vid;
    private Map<String, Object> Input;
    private int Priority;
}
