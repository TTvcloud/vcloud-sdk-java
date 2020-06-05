package com.bytedanceapi.model.sts2;

import lombok.Data;

import java.util.List;

@Data
public class Statement {
    private String effect;
    private List<String> action;
    private List<String> resource;
    private String condition;
}
