package com.bytedanceapi.example.space;

import com.bytedanceapi.model.request.GetSpaceRequest;
import com.bytedanceapi.model.response.GetSpaceResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetSpaceDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        try {
            GetSpaceRequest getSpaceRequest = new GetSpaceRequest();
            getSpaceRequest.setType("list");
            getSpaceRequest.setProjectNames("default");

            GetSpaceResponse getSpaceResponse = vodService.getSpace(getSpaceRequest);
            System.out.println(getSpaceResponse.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
