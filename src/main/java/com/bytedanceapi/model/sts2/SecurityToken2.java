package com.bytedanceapi.model.sts2;

import lombok.Data;

@Data
public class SecurityToken2 {
    private String accessKeyId;
    private String secretAccessKey;
    private String sessionToken;
    private String expiredTime;
    private String currentTime;
}
