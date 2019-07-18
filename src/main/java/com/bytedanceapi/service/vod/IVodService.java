package com.bytedanceapi.service.vod;

import com.bytedanceapi.model.beans.DomainInfo;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.ImgUrl;
import com.bytedanceapi.model.beans.ImgUrlOption;
import com.bytedanceapi.model.request.*;
import com.bytedanceapi.model.response.*;
import com.bytedanceapi.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * The interface Vod service.
 */
public interface IVodService extends IBaseService {

    /**
     * Gets play info.
     *
     * @param params the params
     * @return the play info
     * @throws Exception the exception
     */
    GetPlayInfoResponse getPlayInfo(GetPlayInfoRequest getPlayInfoRequest) throws Exception;

    /**
     * Gets play auth token.
     *
     * @param params the params
     * @return the play auth token
     * @throws Exception the exception
     */
    String getPlayAuthToken(Map<String, String> params) throws Exception;


    /**
     * Start transcode start transcode resp.
     *
     * @param req the req
     * @return the start transcode resp
     * @throws Exception the exception
     */
    StartTranscodeResponse startTranscode(StartTranscodeRequest req) throws Exception;

    /**
     * Gets upload auth token.
     *
     * @param space the space
     * @return the upload auth token
     * @throws Exception the exception
     */
    String getUploadAuthToken(String space) throws Exception;

    /**
     * Gets domain weights.
     *
     * @param params the params
     * @return the domain weights
     * @throws Exception the exception
     */
    GetDomainWeightsResponse getDomainWeights(String spaceName);

    void setFallbackDomainWeights(Map<String, Integer> fallbackWeights);

    DomainInfo getDomainInfo(String spaceName) throws Exception;

    ImgUrl getPosterUrl(String spaceName, String uri, ImgUrlOption imgUrlOption);

    ImgUrl getImageUrl(String spaceName, String uri, ImgUrlOption imgUrlOption);

    GetOriginVideoPlayResponse getOriginVideoPlayInfo(GetOriginVideoPlayRequest getOriginVideoPlayRequest) throws Exception;

    String getRedirectPlay(GetRedirectPlayRequest getRedirectPlayRequest) throws Exception;

    CommitUploadResponse upload(String spaceName, String filePath, String fileType, List<Functions> functions) throws Exception;

    UploadMediaByUrlResponse uploadMediaByUrl(UploadMediaByUrlRequest uploadMediaByUrlRequest) throws Exception;

    SetVideoPublishStatusResponse setVideoPublishStatus(SetVideoPublishStatusRequest setVideoPublishStatusRequest) throws Exception;
}
