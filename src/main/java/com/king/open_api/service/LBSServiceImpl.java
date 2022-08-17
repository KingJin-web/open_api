package com.king.open_api.service;

import com.king.open_api.util.SnCalUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author: Exception
 * @date: 2022-08-15-9:37
 * @description
 */
@Slf4j
public class LBSServiceImpl {

    private String httpUrl = "https://api.map.baidu.com/geocoding/v3/?";

    /**
     * 测试LBS服务：sn校验
     */
    public void testLBS() throws IOException, NoSuchAlgorithmException {
        SnCal snCal = new SnCal();
        String ak = "CLUC13Vn0GXw9zLEGBinuygSlPaxFQXK";
        String address = "湖南省常德市武陵区";
        String sk = "IafSKauGn7La7X1xDOo8yXus0x8xueD0";
        String url = "http://api.map.baidu.com/reverse_geocoding/v3/?";
//        url = url.replaceFirst("http://api.map.baidu.com", "").trim();
//        url = url.replaceFirst("http://yingyan.baidu.com", "").trim();
        Map<String, String> paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("address", address);
        paramsMap.put("output", "json");
        paramsMap.put("ak", ak);
//                snCal.getSn(address, ak, sk);
        String sn = SnCalUtil.getSn(url,paramsMap , sk);
        Map<String, String> param = new LinkedHashMap<>();
        param.put("address", address);
        param.put("output", "json");
        param.put("ak", ak);
        param.put("sn", sn);

        String paramString = toQueryString(param);

        httpUrl = httpUrl + paramString;

        System.out.println(httpUrl);
        Map<String, String> result = loadJSON(httpUrl);
        System.out.println(result);
    }

    public String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();
        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey()).append("=");
            queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8")).append("&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    /**
     * 服务调用
     *
     * @param httpUrl .
     * @return .
     */
    public static Map<String, String> loadJSON(String httpUrl) throws IOException {
        BufferedReader in = null;
        try {
            URL url = new URL(httpUrl);
            URLConnection urlConnection = url.openConnection();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            String res;
            StringBuilder sb = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }

            String str = sb.toString();

            Map<String, String> map = null;
            if (!str.isEmpty()) {
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
                    String lng = str.substring(lngStart + 5, lngEnd);
                    String lat = str.substring(lngEnd + 7, latEnd);
                    map = new HashMap<String, String>();
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        LBS lbs = new LBS();
        lbs.testLBS();
    }
}
