package com.bytedanceapi.service.imagex;

import com.bytedanceapi.model.request.ApplyUploadRequest;
import com.bytedanceapi.model.request.CommitUploadRequest;
import com.bytedanceapi.model.response.ApplyUploadResponse;
import com.bytedanceapi.model.response.CommitUploadResponse;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface IImageXService extends IBaseService {

    /**
     * Apply upload image.
     *
     * @param applyUploadRequest the apply upload request
     * @return the apply upload response
     * @throws Exception the exception
     */
    ApplyUploadResponse applyImageUpload(ApplyUploadRequest applyUploadRequest) throws Exception;

    /**
     * Commit upload image.
     *
     * @param commitUploadRequest the commit upload request
     * @return the commit upload response
     * @throws Exception the exception
     */
    CommitUploadResponse commitImageUpload(CommitUploadRequest commitUploadRequest) throws Exception;

    /**
     * Upload image data.
     *
     * @param request the apply upload request
     * @param imageDatas image data array
     * @throws Exception the exception
     */
    CommitUploadResponse uploadImages(ApplyUploadRequest request, List<byte[]> imageDatas) throws Exception;

    /**
     * Get image upload token.
     *
     * @param params the params
     * @return the upload token
     * @throws Exception the exception
     */
    String getUploadToken(Map<String, String> params) throws Exception;

    /**
     * Get image upload sts2 auth with default expire time (1 hour).
     *
     * @param serviceIds service id list allowed to upload image to
     * @return the upload sts2 auth
     * @throws Exception the exception
     */
    SecurityToken2 getUploadSts2(List<String> serviceIds) throws Exception;

    /**
     * Get image upload sts2 auth.
     *
     * @param serviceIds service id list allowed to upload image to
     * @param expire expire time in milliseconds
     * @return the upload sts2 auth
     * @throws Exception the exception
     */
    SecurityToken2 getUploadSts2WithExpire(List<String> serviceIds, long expire) throws Exception;
}
