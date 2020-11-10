package com.bytedanceapi.service.vod;

import com.bytedanceapi.model.beans.DomainInfo;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.ImgUrl;
import com.bytedanceapi.model.beans.ImgUrlOption;
import com.bytedanceapi.model.request.*;
import com.bytedanceapi.model.response.*;
import com.bytedanceapi.model.vod.request.VodGetRecommendedPosterRequest;
import com.bytedanceapi.model.vod.request.VodGetVideoInfosRequest;
import com.bytedanceapi.model.vod.request.VodUpdateVideoInfoRequest;
import com.bytedanceapi.model.vod.request.VodUpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.vod.response.VodGetRecommendedPosterResponse;
import com.bytedanceapi.model.vod.response.VodGetVideoInfosResponse;
import com.bytedanceapi.model.vod.response.VodUpdateVideoInfoResponse;
import com.bytedanceapi.model.vod.response.VodUpdateVideoPublishStatusResponse;
import com.bytedanceapi.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * The interface Vod service.
 */
public interface IVodService extends IBaseService {


    GetSpaceResponse getSpace(GetSpaceRequest getSpaceRequest) throws Exception;


    /**
     * getPlayInfo.
     *
     * @param input com.bytedanceapi.model.vod.request.VodGetPlayInfoRequest
     * @return com.bytedanceapi.model.vod.response.VodGetPlayInfoResponse
     * @throws Exception the exception
     */
    com.bytedanceapi.model.vod.response.VodGetPlayInfoResponse getPlayInfo(com.bytedanceapi.model.vod.request.VodGetPlayInfoRequest input) throws Exception;

    /**
     * getOriginalPlayInfo.
     *
     * @param input com.bytedanceapi.model.vod.request.VodGetOriginalPlayInfoRequest
     * @return com.bytedanceapi.model.vod.response.VodGetOriginalPlayInfoResponse
     * @throws Exception the exception
     */
    com.bytedanceapi.model.vod.response.VodGetOriginalPlayInfoResponse getOriginalPlayInfo(com.bytedanceapi.model.vod.request.VodGetOriginalPlayInfoRequest input) throws Exception;

    /**
     * Gets play auth token.
     *
     * @param params the params
     * @return the play auth token
     * @throws Exception the exception
     */
    String getPlayAuthToken(Map<String, String> params) throws Exception;



    /**
     * Gets redirect play.
     *
     * @param getRedirectPlayRequest the get redirect play request
     * @return the redirect play
     * @throws Exception the exception
     */
//    String getRedirectPlay(GetRedirectPlayRequest getRedirectPlayRequest) throws Exception;


    /**
     * Start workflow.
     *
     * @param req the req
     * @return the start workflow resp
     * @throws Exception the exception
     */
    StartWorkflowResponse startWorkflow(StartWorkflowRequest req) throws Exception;

    /**
     * Gets domain weights.
     *
     * @param spaceName the space name
     * @return the domain weights
     */
    GetDomainWeightsResponse getDomainWeights(String spaceName);

    /**
     * Sets fallback domain weights.
     *
     * @param fallbackWeights the fallback weights
     */
    void setFallbackDomainWeights(Map<String, Integer> fallbackWeights);

    /**
     * Shutdown.
     */
    void shutdown();

    /**
     * Gets domain info.
     *
     * @param spaceName the space name
     * @return the domain info
     * @throws Exception the exception
     */
    DomainInfo getDomainInfo(String spaceName) throws Exception;

    /**
     * Gets poster url.
     *
     * @param spaceName    the space name
     * @param uri          the uri
     * @param imgUrlOption the img url option
     * @return the poster url
     */
    ImgUrl getPosterUrl(String spaceName, String uri, ImgUrlOption imgUrlOption);

    /**
     * Gets upload auth token.
     *
     * @param params the params
     * @return the upload auth token
     * @throws Exception the exception
     */
    String getUploadAuthToken(Map<String, String> params) throws Exception;

    /**
     * Apply upload apply upload response.
     *
     * @param applyUploadRequest the apply upload request
     * @return the apply upload response
     * @throws Exception the exception
     */
    ApplyUploadResponse applyUpload(ApplyUploadRequest applyUploadRequest) throws Exception;

    /**
     * Commit upload commit upload response.
     *
     * @param commitUploadRequest the commit upload request
     * @return the commit upload response
     * @throws Exception the exception
     */
    CommitUploadResponse commitUpload(CommitUploadRequest commitUploadRequest) throws Exception;

    /**
     * Upload commit upload response.
     *
     * @param spaceName the space name
     * @param filePath  the file path
     * @param fileType  the file type
     * @param functions the functions
     * @return the commit upload response
     * @throws Exception the exception
     */
    CommitUploadResponse uploadVideo(String spaceName, String filePath, String fileType, List<Functions> functions) throws Exception;

    /**
     * Upload poster string.
     *
     * @param vid       the vid
     * @param spaceName the space name
     * @param filePath  the file path
     * @param fileType  the file type
     * @return the string
     * @throws Exception the exception
     */
    String uploadPoster(String vid, String spaceName, String filePath, String fileType) throws Exception;

    /**
     * Upload media by url upload media by url response.
     *
     * @param uploadMediaByUrlRequest the upload media by url request
     * @return the upload media by url response
     * @throws Exception the exception
     */
    UploadMediaByUrlResponse uploadMediaByUrl(UploadMediaByUrlRequest uploadMediaByUrlRequest) throws Exception;

//    /**
//     * Update video info modify video info response.
//     *
//     * @param updateVideoInfoRequest the update video info request
//     * @return the modify video info response
//     * @throws Exception the exception
//     */
//    void updateVideoInfo(UpdateVideoInfoRequest updateVideoInfoRequest) throws Exception;
    /**
     * updateVideoInfo.
     *
     * @param input com.bytedanceapi.model.common.UpdateVideoInfoRequest
     * @return com.bytedanceapi.model.common.UpdateVideoInfoResponse
     * @throws Exception the exception
     */
    VodUpdateVideoInfoResponse updateVideoInfo(VodUpdateVideoInfoRequest input) throws Exception;

    /**
     * Sets video publish status.
     *
     * @param req the updateVideoPublistStatus request
     * @return the video publish status
     * @throws Exception the exception
     */
    VodUpdateVideoPublishStatusResponse updateVideoPublishStatus(VodUpdateVideoPublishStatusRequest req) throws Exception;

    /**
     * Update video info modify video info response.
     *
     * @param req the request
     * @return the video info list response
     * @throws Exception the exception
     */
    VodGetVideoInfosResponse getVideoInfos(VodGetVideoInfosRequest req) throws Exception;

    /**
     * Update video info modify video info response.
     *
     * @param req the request
     * @return the video poster uri list response
     * @throws Exception the exception
     */
    VodGetRecommendedPosterResponse getRecommendedPoster(VodGetRecommendedPosterRequest req) throws Exception;
}
