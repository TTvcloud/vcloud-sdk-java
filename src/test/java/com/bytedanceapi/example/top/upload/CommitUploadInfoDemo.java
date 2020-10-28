package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.FunctionsSnapshotInput;
import com.bytedanceapi.model.request.ApplyUploadInfoRequest;
import com.bytedanceapi.model.request.CommitUploadInfoRequest;
import com.bytedanceapi.model.request.CommitUploadRequest;
import com.bytedanceapi.model.response.ApplyUploadInfoResponse;
import com.bytedanceapi.model.response.CommitUploadInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CommitUploadInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        String space = "your space name";
        String session = "";

        List<Functions> functionsList = new ArrayList<>();
        Functions getMetaFunc = new Functions();
        getMetaFunc.setName("GetMeta");
        functionsList.add(getMetaFunc);

        Functions snapShotFunc = new Functions();
        snapShotFunc.setName("Snapshot");
        FunctionsSnapshotInput functionsSnapshotInput = new FunctionsSnapshotInput();
        functionsSnapshotInput.setSnapshotTime(2.3);
        snapShotFunc.setInput(functionsSnapshotInput);
        functionsList.add(snapShotFunc);


        try {
            CommitUploadInfoRequest commitUploadInfoRequest = new CommitUploadInfoRequest();
            commitUploadInfoRequest.setSpaceName(space);
            commitUploadInfoRequest.setSessionKey(session);
            commitUploadInfoRequest.setFunctions(JSON.toJSONString(functionsList));

            CommitUploadInfoResponse commitUploadInfoResponse = vodService.commitUploadInfo(commitUploadInfoRequest);
            System.out.println(JSON.toJSONString(commitUploadInfoResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
