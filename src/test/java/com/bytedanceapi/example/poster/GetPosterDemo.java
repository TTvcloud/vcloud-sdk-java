package com.bytedanceapi.example.poster;

import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.beans.DomainInfo;
import com.bytedanceapi.model.beans.ImgUrl;
import com.bytedanceapi.model.beans.ImgUrlOption;
import com.bytedanceapi.model.response.GetDomainWeightsResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class GetPosterDemo {

    public static void main(String[] args) {
        // step1: construct IVodService
        IVodService vodService = VodServiceImpl.getInstance();

        // step2: call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("ak");
        // vodService.setSecretKey("sk");

        String spaceName = "your spaceName";
        String posterUri = "your uri";

        assert vodService.getAccessKey() != null;
        assert vodService.getSecretKey() != null;

        Map<String, Integer> fallbackWeights = new HashMap<>();
        fallbackWeights.put("your fallback domain", 10);
        // step3: set fallback domain if necessary, you can set the it to the poster domain you set in the console window
        vodService.setFallbackDomainWeights(fallbackWeights);

        GetDomainWeightsResponse getDomainWeightsResponse = vodService.getDomainWeights(spaceName);
        System.out.println(getDomainWeightsResponse.getResult());

        for (int j = 0; j < 10; j++) {
            try {
                DomainInfo domainInfo = vodService.getDomainInfo(spaceName);
                System.out.println(domainInfo);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // get poster img url
        ImgUrlOption imgUrlOption = new ImgUrlOption();
        imgUrlOption.setHttps(true);
        imgUrlOption.setVodTplSmartCrop(600, 392);
        imgUrlOption.setFomat(Const.FORMAT_AWEBP);


        ImgUrl imgUrl = vodService.getPosterUrl(spaceName, posterUri, imgUrlOption);
        System.out.println(imgUrl.getMainUrl());
        System.out.println(imgUrl.getBackupUrl());

        // step4: notice, shutdown the vodService if no use any more, otherwise the process would not exit
        vodService.shutdown();
    }
}
