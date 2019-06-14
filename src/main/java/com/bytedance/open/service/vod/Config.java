package com.bytedance.open.service.vod;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Config {


    public static com.bytedance.open.model.ServiceInfo serviceInfo = new com.bytedance.open.model.ServiceInfo(
        new HashMap<String, Object>() {
            {
                put(com.bytedance.open.util.Const.ConnectionTimeout, 5000);
                put(com.bytedance.open.util.Const.SocketTimeout, 5000);
                put(com.bytedance.open.util.Const.Host, "vod.bytedanceapi.com");
                put(com.bytedance.open.util.Const.Header, new ArrayList<Header>() {
                    {
                        add(new BasicHeader("Accept", "application/json"));
                    }
                });
                put(com.bytedance.open.util.Const.Credentials, new com.bytedance.open.model.Credentials(com.bytedance.open.util.Const.RegionCnNorth1, "vod"));
            }
        }
    );

    public static Map<String, com.bytedance.open.model.ApiInfo> apiInfoList = new HashMap<String, com.bytedance.open.model.ApiInfo>() {
        {
            put("GetPlayInfo", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(com.bytedance.open.util.Const.Method, "GET");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "GetPlayInfo"));
                                add(new BasicNameValuePair("Version", "2019-03-15"));
                            }
                        });
                    }
                }
            ));
            put("StartTranscode", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(com.bytedance.open.util.Const.Method, "POST");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "StartTranscode"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("UploadMediaByUrl", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedance.open.util.Const.Method, "GET");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "UploadMediaByUrl"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("ApplyUpload", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedance.open.util.Const.Method, "GET");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "ApplyUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("CommitUpload", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedance.open.util.Const.Method, "POST");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "CommitUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("SetVideoPublishStatus", new com.bytedance.open.model.ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(com.bytedance.open.util.Const.Method, "GET");
                        put(com.bytedance.open.util.Const.Path, "/");
                        put(com.bytedance.open.util.Const.Query, new ArrayList<NameValuePair>() {
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
