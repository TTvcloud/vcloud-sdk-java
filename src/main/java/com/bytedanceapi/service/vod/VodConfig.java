package com.bytedanceapi.service.vod;

import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.ApiInfo;
import com.bytedanceapi.model.Credentials;
import com.bytedanceapi.model.ServiceInfo;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VodConfig {
    // ResourceSpaceFormat space的资源结构
    public static final String RESOURCE_SPACE_FORMAT = "trn:vod:%s:*:space/%s";
    // ResourceVideoFormat vid的视频结构r
    public static final String RESOURCE_VIDEO_FORMAT = "trn:vod::*:video_id/%s";
    // ResourceStreamTypeFormat  stream type理论和账号无关
    public static final String RESOURCE_STREAM_TYPE_FORMAT = "trn:vod:::stream_type/%s";
    // ResourceWatermarkFormat 水印信息与账号有关,与region无关
    public static final String RESOURCE_WATERMARK_FORMAT = "trn:vod::*:watermark/%s";

    public static final String ACTION_GET_PLAY_INFO = "vod:GetPlayInfo";

    public static final String STAR = "*";

    public static Map<String, ServiceInfo> ServiceInfoMap = new HashMap<String, ServiceInfo>() {
        {
            put(Const.REGION_CN_NORTH_1, new ServiceInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.CONNECTION_TIMEOUT, 5000);
                            put(Const.SOCKET_TIMEOUT, 5000);
                            put(Const.Host, "vod.bytedanceapi.com");
                            put(Const.Header, new ArrayList<Header>() {
                                {
                                    add(new BasicHeader("Accept", "application/json"));
                                }
                            });
                            put(Const.Credentials, new Credentials(Const.REGION_CN_NORTH_1, "vod"));
                        }
                    }
            ));
            put(Const.REGION_AP_SINGAPORE_1, new ServiceInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.CONNECTION_TIMEOUT, 5000);
                            put(Const.SOCKET_TIMEOUT, 5000);
                            put(Const.Host, "vod.ap-singapore-1.bytedanceapi.com");
                            put(Const.Header, new ArrayList<Header>() {
                                {
                                    add(new BasicHeader("Accept", "application/json"));
                                }
                            });
                            put(Const.Credentials, new Credentials(Const.REGION_AP_SINGAPORE_1, "vod"));
                        }
                    }
            ));
            put(Const.REGION_US_EASE_1, new ServiceInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.CONNECTION_TIMEOUT, 5000);
                            put(Const.SOCKET_TIMEOUT, 5000);
                            put(Const.Host, "vod.us-east-1.bytedanceapi.com");
                            put(Const.Header, new ArrayList<Header>() {
                                {
                                    add(new BasicHeader("Accept", "application/json"));
                                }
                            });
                            put(Const.Credentials, new Credentials(Const.REGION_US_EASE_1, "vod"));
                        }
                    }
            ));
        }
    };

    public static Map<String, ApiInfo> apiInfoList = new HashMap<String, ApiInfo>() {
        {
            put(Const.GetPlayInfo, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetPlayInfo));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.StartTranscode, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "POST");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.StartTranscode));
                                    add(new BasicNameValuePair("Version", "2018-01-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.UploadMediaByUrl, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.UploadMediaByUrl));
                                    add(new BasicNameValuePair("Version", "2018-01-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.ApplyUpload, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.ApplyUpload));
                                    add(new BasicNameValuePair("Version", "2018-01-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.CommitUpload, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "POST");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.CommitUpload));
                                    add(new BasicNameValuePair("Version", "2018-01-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.UpdateVideoPublishStatus, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.UpdateVideoPublishStatus));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.GetCdnDomainWeights, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetCdnDomainWeights));
                                    add(new BasicNameValuePair("Version", "2019-07-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.GetOriginVideoPlayInfo, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetOriginVideoPlayInfo));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.RedirectPlay, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.RedirectPlay));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.UpdateVideoInfo, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.UpdateVideoInfo));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.GetSpace, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetSpace));
                                    add(new BasicNameValuePair("Version", "2018-12-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.GetVideoInfos, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetVideoInfos));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
            put(Const.GetRecommendedPosters, new ApiInfo(
                    new HashMap<String, Object>() {
                        {
                            put(Const.Method, "GET");
                            put(Const.Path, "/");
                            put(Const.Query, new ArrayList<NameValuePair>() {
                                {
                                    add(new BasicNameValuePair("Action", Const.GetRecommendedPosters));
                                    add(new BasicNameValuePair("Version", "2020-08-01"));
                                }
                            });
                        }
                    }
            ));
        }
    };
}
