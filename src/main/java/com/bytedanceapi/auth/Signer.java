package com.bytedanceapi.auth;

public interface Signer {

    public void sign(com.bytedanceapi.model.SignableRequest request, com.bytedanceapi.model.Credentials credentials) throws Exception;

    public String signUrl(com.bytedanceapi.model.SignableRequest request, com.bytedanceapi.model.Credentials credentials) throws Exception;
}
