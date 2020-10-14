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
        vodService.setAccessKey("AKLTNDQ2YTRlNTBiYTg1NDcyNmE3MDA1MTUzNzc5MWMwNmI");
        vodService.setSecretKey("1ZOtyBZ89VERZdOfiUrPf24a3tTjRo1XIJbzccVHMrBvZo1jEn60LjClP2t05qWz");

        String space = "james-test";
        String session = "eyJleHRyYSI6InZpZGM9Ym9lXHUwMDI2dnRzPTE2MDIzMTE3MTMzODA3Njg5MjVcdTAwMjZob3N0PWVkZ2UtdXBsb2FkLWJvZS5ieXRlZGFuY2UubmV0XHUwMDI2cmVnaW9uPUludHJhbmV0XHUwMDI2ZWRnZV9ub2RlPWJvZVx1MDAyNnVwbG9hZF9tb2RlPXNlcmlhbFx1MDAyNnN0cmF0ZWd5PWlkY19maWx0ZXJcdTAwMjZ1c2VyX2lwPTEwLjEuMTQuOTciLCJmaWxlVHlwZSI6InZpZGVvIiwic2NlbmUiOiIiLCJ0b2tlbiI6ImV5Sm9iM04wSWpvaVpXUm5aUzExY0d4dllXUXRZbTlsTG1KNWRHVmtZVzVqWlM1dVpYUWlMQ0p1YjI1alpTSTZJbnBOVmxKNlEzRldJaXdpZFhCc2IyRmtYM05wWjI0aU9pSlRWMVEwTms5T1YwNDVTakJFVDBaRlQwTTFXRHBRU1c5UFRVNXNkMVpGWVZCT1VucG5iR2xoYnpFeloyWTNPWFpLYWtaRlRuWlZMWFJIY0VFd1lYbEJQVHBhUjFab1drZDRjR0p0VlRaSlJFVXlUVVJKZWs5VVozaE5WRTA5T2s1RWJHaGFSRlpzV20xR2FWbDZUbWhPUjBsNlRXMUtiRnBFVm10YWFrMHdXbTFGTTFwdFVteFpNa1U5SW4wPTo2YWYyMjYzZDRkYjIyZDc4MjgxNGU2MmFiOGZiYjViZjZiYzNmNTI0YjlhZDdkODZjMGViYzhhNzM1OTk2ODExIiwidXJpIjoidG9zLWJvZS12LWRhMTQyMS80OWFkNWVmYWJjM2E0YjMyYmVkNWRmMzRmYTdmZGVjYSIsInZpZCI6InYwYzI1NWZhMDA3YWJ1MGxjOGEwb2VqNzdsYmJ2ZzgwIn0=";

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
