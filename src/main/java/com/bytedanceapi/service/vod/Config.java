package com.bytedanceapi.service.vod;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Config {


    public static com.bytedanceapi.model.ServiceInfo serviceInfo = new com.bytedanceapi.model.ServiceInfo(
        new HashMap<String, Object>() {
            {
                put(com.bytedanceapi.util.Const.ConnectionTimeout, 5000);
                put(com.bytedanceapi.util.Const.SocketTimeout, 5000);
                put(com.bytedanceapi.util.Const.Host, "vod.bytedanceapi.com");
                put(com.bytedanceapi.util.Const.Header, new ArrayList<Header>() {
                    {
                        add(new BasicHeader("Accept", "application/json"));
                    }
                });
                put(com.bytedanceapi.util.Const.Credentials, new com.bytedanceapi.model.Credentials(com.bytedanceapi.util.Const.RegionCnNorth1, "vod"));
            }
        }
    );

    public static Map<String, com.bytedanceapi.model.ApiInfo> apiInfoList = new HashMap<String, com.bytedanceapi.model.ApiInfo>() {
        {
            put("GetPlayInfo", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(com.bytedanceapi.util.Const.Method, "GET");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "GetPlayInfo"));
                                add(new BasicNameValuePair("Version", "2019-03-15"));
                            }
                        });
                    }
                }
            ));
            put("StartTranscode", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(com.bytedanceapi.util.Const.Method, "POST");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "StartTranscode"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("UploadMediaByUrl", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedanceapi.util.Const.Method, "GET");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "UploadMediaByUrl"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("ApplyUpload", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedanceapi.util.Const.Method, "GET");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "ApplyUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("CommitUpload", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedanceapi.util.Const.Method, "POST");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "CommitUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("SetVideoPublishStatus", new com.bytedanceapi.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedanceapi.util.Const.Method, "GET");
                        put(com.bytedanceapi.util.Const.Path, "/");
                        put(com.bytedanceapi.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "SetVideoPublishStatus"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
        }
    };
}
