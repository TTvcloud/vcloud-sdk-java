package com.bytedanceapi.model.sts2;

import lombok.Data;

@Data
public class InnerToken {
    private String ltAccessKeyId;
    private String accessKeyId;
    private String signedSecretAccessKey;
    private long expiredTime;
    private String policyString;
    private String signature;
}

