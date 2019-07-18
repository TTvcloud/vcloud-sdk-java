package com.bytedanceapi.model.beans;

import lombok.Data;

import java.util.Map;

@Data
public class FunctionsEntryptionInput {
    Map<String, String> Config;
    Map<String, String> PolicyParams;
}
