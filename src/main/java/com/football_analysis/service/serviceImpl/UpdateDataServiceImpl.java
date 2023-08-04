package com.football_analysis.service.serviceImpl;

import com.football_analysis.config.FnCommon;
import com.football_analysis.service.UpdateDataService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateDataServiceImpl implements UpdateDataService {
    @Override
    public void callApiRealTimeData() {
        String url = "https://api.thesports.com/v1/football/match/detail_live";
        Map<String,String> param = new HashMap<>();
        param.put("user","balllive");
        param.put("secret","ca6b2a2cdcd8e9b644567da662bf5c24");
        String response = FnCommon.doGetRequest(url,param,null);
        System.out.println(response);
    }

}
