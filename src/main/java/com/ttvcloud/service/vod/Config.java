package com.ttvcloud.service.vod;

import com.ttvcloud.model.ApiInfo;
import com.ttvcloud.model.Credentials;
import com.ttvcloud.model.ServiceInfo;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.ttvcloud.util.Const.*;

public class Config {


    public static ServiceInfo serviceInfo = new ServiceInfo(
        new HashMap<String, Object>() {
            {
                put(ConnectionTimeout, 5000);
                put(SocketTimeout, 5000);
                put(Host, "vod.bytedanceapi.com");
                put(Header, new ArrayList<Header>() {
                    {
                        add(new BasicHeader("Accept", "application/json"));
                    }
                });
                put(Credentials, new Credentials(RegionCnNorth1, "vod"));
            }
        }
    );

    public static Map<String, ApiInfo> apiInfoList = new HashMap<String, ApiInfo>() {
        {
            put("GetPlayInfo", new ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(Method, "GET");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "GetPlayInfo"));
                                add(new BasicNameValuePair("Version", "2019-03-15"));
                            }
                        });
                    }
                }
            ));
            put("StartTranscode", new ApiInfo(
                new HashMap<String, Object>(){
                    {
                        put(Method, "POST");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "StartTranscode"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("UploadMediaByUrl", new ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(Method, "GET");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "UploadMediaByUrl"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("ApplyUpload", new ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(Method, "GET");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "ApplyUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("CommitUpload", new ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(Method, "POST");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
                            {
                                add(new BasicNameValuePair("Action", "CommitUpload"));
                                add(new BasicNameValuePair("Version", "2018-01-01"));
                            }
                        });
                    }
                }
            ));
            put("SetVideoPublishStatus", new ApiInfo(
                new HashMap<String, Object>() {
                    {
                        put(Method, "GET");
                        put(Path, "/");
                        put(Query, new ArrayList<NameValuePair>() {
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
