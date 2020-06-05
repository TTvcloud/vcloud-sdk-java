package com.bytedanceapi.example.sts2;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import com.bytedanceapi.util.Time;

import java.util.ArrayList;
import java.util.List;

public class VodSts2Demo {

    public static void main(String[] args) throws Exception {
        VodServiceImpl vodService = (VodServiceImpl) VodServiceImpl.getInstance();

        List<String> vidList = new ArrayList<>();
        List<String> streamTypeList = new ArrayList<>();
        List<String> watermarkList = new ArrayList<>();

        SecurityToken2 sts2 = vodService.getVideoPlayAuth(vidList,streamTypeList,watermarkList);
        System.out.println(JSON.toJSONString(sts2));

        sts2 = vodService.getVideoPlayAuthWithExpiredTime(vidList,streamTypeList,watermarkList, Time.Minute);
        System.out.println(JSON.toJSONString(sts2));
    }

}
