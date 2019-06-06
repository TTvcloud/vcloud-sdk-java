package com.ttvcloud.auth;

import com.ttvcloud.model.Credentials;
import com.ttvcloud.model.SignableRequest;

public interface Signer {

    void sign(SignableRequest request, Credentials credentials) throws Exception;
}
