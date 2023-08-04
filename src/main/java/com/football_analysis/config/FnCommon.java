package com.football_analysis.config;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;


public class FnCommon{
    private static final Logger LOGGER = LoggerFactory.getLogger(FnCommon.class);

    public static String doGetRequest(String url, Map<String, String> params, String token) {
        String strRes = null;
        OkHttpClient client = new OkHttpClient();
        try {
            setOkHtppClient(client);
            HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();

            if (params != null) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    httpBuider.addQueryParameter(param.getKey(), param.getValue());
                }
            }
            Request request = null;
            if (token != null) {
                request = new Request.Builder()
                        .header("Accept", "application/json")
                        .header("Authorization", "Bearer " + token)
                        .url(httpBuider.build())
                        .get()
                        .build();
            } else {
                request = new Request.Builder()
                        .url(httpBuider.build())
                        .get()
                        .build();
            }
            Response response = client.newCall(request).execute();
            try (ResponseBody responseBody = response.body()) {
                strRes = responseBody.string();
            }
            return strRes;
        } catch (Exception e) {
            LOGGER.error("Has error", e);
        }
        return strRes;
    }

    public static void setOkHtppClient(OkHttpClient client) {
        client.setConnectTimeout(40, TimeUnit.SECONDS);
        client.setReadTimeout(40, TimeUnit.SECONDS);
        client.setWriteTimeout(40, TimeUnit.SECONDS);
    }

}
