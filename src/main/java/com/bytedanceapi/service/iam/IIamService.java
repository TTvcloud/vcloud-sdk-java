package com.bytedanceapi.service.iam;

import com.bytedanceapi.model.request.ListUsersRequest;
import com.bytedanceapi.model.response.ListUsersResponse;

public interface IIamService {
    ListUsersResponse listUsers(ListUsersRequest listUsersRequest) throws Exception;
}
