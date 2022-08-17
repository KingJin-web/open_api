package com.king.open_api.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.util.SnCalUtil;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.Map;
import com.king.open_api.vo.ResultObj;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author: Exception
 * @date: 2022-08-15-9:37
 * @description
 */
@Service
public class LBSServiceImpl {

    private String httpUrl = "https://api.map.baidu.com/geocoding/v3/?";
    Logger logger = org.slf4j.LoggerFactory.getLogger(LBSServiceImpl.class);

    @Value("${baiduLBS.ak}")
    private String ak;
    @Value("${baiduLBS.sk}")
    private String sk;

    /**
     * 测试LBS服务：sn校验
     */
    public void testLBS() throws IOException {
        String address = "湖南省常德市武陵区";
        String url = "http://api.map.baidu.com/reverse_geocoding/v3/?";
        java.util.Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("address", address);
        paramsMap.put("output", "json");
        paramsMap.put("ak", ak);
//                snCal.getSn(address, ak, sk);
        String sn = SnCalUtil.getSn(url, paramsMap, sk);
        java.util.Map<String, String> param = new LinkedHashMap<>();
        param.put("address", address);
        param.put("output", "json");
        param.put("ak", ak);
        param.put("sn", sn);

        String paramString = toQueryString(param);

        httpUrl = httpUrl + paramString;

        System.out.println(httpUrl);
        java.util.Map<String, String> result = loadJSON(httpUrl);
        System.out.println(result);
    }

    public String toQueryString(java.util.Map<?, ?> data) throws UnsupportedEncodingException {
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
     * 加载JSON数据
     *
     * @param url
     * @return
     * @throws IOException
     */
    public Map loadJSON2(String url, String address) {
        String param = HttpUtils.get(url);
        JSONObject jsonObject = JSON.parseObject(param);
        if (jsonObject.getInteger("status") == 0) {
            //经纬度
            String lng = jsonObject.getJSONObject("result").getJSONObject("location").getString("lng");
            String lat = jsonObject.getJSONObject("result").getJSONObject("location").getString("lat");
            return new Map(address, lng, lat);
        }
        return null;
    }

    /**
     * 服务调用
     *
     * @param httpUrl .
     * @return .
     */
    public static java.util.Map<String, String> loadJSON(String httpUrl) throws IOException {
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

            java.util.Map<String, String> map = null;
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

    /**
     * 通过地址获取经纬度
     */
    public ResultObj getLngLat(String address) {
        if (StringUtils.isEmpty(address)) {
            return ResultObj.error("地址不能为空");
        }
        try {
            java.util.Map<String, String> paramsMap = new LinkedHashMap<>();
            paramsMap.put("address", address);
            paramsMap.put("output", "json");
            paramsMap.put("ak", ak);
            String sn = SnCalUtil.getSn(httpUrl, paramsMap, sk);
            paramsMap.put("sn", sn);
            String paramString = toQueryString(paramsMap);
            httpUrl = httpUrl + paramString;
            Map as = loadJSON2(httpUrl, address);
            if (StringUtils.isEmpty(as)) {
                return ResultObj.error("获取经纬度失败");
            } else {
                return ResultObj.success("获取经纬度成功", as);
            }
        } catch (Exception e) {
            logger.error("获取经纬度失败", e);
            return ResultObj.error("获取经纬度失败");
        }

    }
}
