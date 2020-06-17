package com.bytedanceapi.example.sts2;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.sts2.Policy;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.model.sts2.Statement;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import com.bytedanceapi.util.Sts2Utils;
import com.bytedanceapi.util.Time;

import java.util.ArrayList;

public class Sts2SignDemo {

    public static void main(String[] args) throws Exception {
        Policy inlinePolicy = new Policy();

//        ArrayList<String> action = new ArrayList<>();
//        action.add("iam:*");
//        ArrayList<String> resources = new ArrayList<>();
//        Statement statement = Sts2Utils.newAllowStatement(action,resources);

        ArrayList<String> action = new ArrayList<>();
        action.add("*");
        ArrayList<String> resources = new ArrayList<>();
        resources.add("*");
        Statement statement = Sts2Utils.newAllowStatement(action,resources);

        inlinePolicy.addStatement(statement);

        IVodService vodService = VodServiceImpl.getInstance();

        SecurityToken2 sts2 = vodService.signSts2(inlinePolicy, Time.Hour);
        System.out.println(JSON.toJSONString(sts2));
    }

}
