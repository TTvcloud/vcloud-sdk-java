package com.bytedanceapi.util;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {

    public static List<NameValuePair> mapToPairList(Map<String, String> params) {
        List<NameValuePair> res = new ArrayList<NameValuePair>();

        if (params != null) {
            for (String key : params.keySet()) {
                res.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        return res;
    }
}
