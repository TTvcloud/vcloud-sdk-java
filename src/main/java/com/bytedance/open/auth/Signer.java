package com.bytedance.open.auth;

public interface Signer {

    public void sign(com.bytedance.open.model.SignableRequest request, com.bytedance.open.model.Credentials credentials) throws Exception;

    public String signUrl(com.bytedance.open.model.SignableRequest request, com.bytedance.open.model.Credentials credentials) throws Exception;
}
