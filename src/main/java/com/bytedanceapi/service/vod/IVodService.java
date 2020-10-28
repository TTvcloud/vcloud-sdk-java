package com.bytedanceapi.service.vod;

import com.bytedanceapi.model.beans.DomainInfo;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.ImgUrl;
import com.bytedanceapi.model.beans.ImgUrlOption;
import com.bytedanceapi.model.common.VodGetOriginalPlayInfoRequest;
import com.bytedanceapi.model.common.VodGetOriginalPlayInfoResponse;
import com.bytedanceapi.model.common.VodGetPlayInfoRequest;
import com.bytedanceapi.model.common.VodGetPlayInfoResponse;
import com.bytedanceapi.model.request.*;
import com.bytedanceapi.model.response.*;
import com.bytedanceapi.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * The interface Vod service.
 */
public interface IVodService extends IBaseService {


    GetSpaceResponse getSpace(GetSpaceRequest getSpaceRequest) throws Exception;

    /**
     * Gets play info.
     *
     * @param getPlayInfoRequest the get play info request
     * @return the play info
     * @throws Exception the exception
     */
    VodGetPlayInfoResponse getPlayInfo(VodGetPlayInfoRequest getPlayInfoRequest) throws Exception;

    /**
     * Gets play auth token.
     *
     * @param params the params
     * @return the play auth token
     * @throws Exception the exception
     */
    String getPlayAuthToken(Map<String, String> params) throws Exception;

    /**
     * Gets origin video play info.
     *
     * @param getOriginVideoPlayRequest the get origin video play request
     * @return the origin video play info
     * @throws Exception the exception
     */
    VodGetOriginalPlayInfoResponse getOriginVideoPlayInfo(VodGetOriginalPlayInfoRequest getOriginVideoPlayRequest) throws Exception;

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
     * Sets video publish status.
     *
     * @param req the updateVideoPublistStatus request
     * @return the video publish status
     * @throws Exception the exception
     */
    void updateVideoPublishStatus(UpdateVideoPublishStatusRequest req) throws Exception;

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

    /**
     * Update video info modify video info response.
     *
     * @param updateVideoInfoRequest the update video info request
     * @return the modify video info response
     * @throws Exception the exception
     */
    void updateVideoInfo(UpdateVideoInfoRequest updateVideoInfoRequest) throws Exception;

    /**
     * Update video info modify video info response.
     *
     * @param req the request
     * @return the video info list response
     * @throws Exception the exception
     */
    GetVideoInfosResponse getVideoInfos(GetVideoInfosRequest req) throws Exception;

    /**
     * Update video info modify video info response.
     *
     * @param req the request
     * @return the video poster uri list response
     * @throws Exception the exception
     */
    GetRecommendedPostersResponse getRecommendedPosters(GetRecommendedPostersRequest req) throws Exception;
}
