package com.bytedanceapi.service.iam;

import com.bytedanceapi.model.request.ListUsersRequest;
import com.bytedanceapi.model.response.ListUsersResponse;

/**
 * The interface Iam service.
 */
public interface IIamService {
    /**
     * List users.
     *
     * @param listUsersRequest the list users request
     * @return the list users response
     * @throws Exception the exception
     */
    ListUsersResponse listUsers(ListUsersRequest listUsersRequest) throws Exception;
}
