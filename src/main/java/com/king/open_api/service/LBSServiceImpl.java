package com.king.open_api.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.util.SnCalUtil;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.MapVo;
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
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author: Exception
 * @date: 2022-08-15-9:37
 * @description
 */
@Service
public class LBSServiceImpl {


    Logger logger = org.slf4j.LoggerFactory.getLogger(LBSServiceImpl.class);

    @Value("${baiduLBS.ak}")
    private String ak;
    @Value("${baiduLBS.sk}")
    private String sk;


    /**
     * 加载JSON数据
     *
     * @param url
     * @return
     * @throws IOException
     */
    public MapVo loadJSON2(String url, String address) {
        try {
            String param = HttpUtils.get(url);
            JSONObject jsonObject = JSON.parseObject(param);
            if (jsonObject.getInteger("status") == 0) {
                //经纬度
                String lng = jsonObject.getJSONObject("result").getJSONObject("location").getString("lng");
                String lat = jsonObject.getJSONObject("result").getJSONObject("location").getString("lat");
                return new MapVo(address, lng, lat);
            } else {
                throw new RuntimeException("百度LBS服务异常");
            }
        } catch (Exception e) {
            logger.error("loadJSON2 error", e);
            throw new RuntimeException("百度LBS服务异常");
        }
    }


    /**
     * 通过地址获取经纬度
     */
    public ResultObj getLngLat(String address) {
        if (StringUtils.isEmpty(address)) {
            return ResultObj.error("地址不能为空");
        }
        try {
            logger.info("getLngLat address:{}", address);
            String httpUrl = "https://api.map.baidu.com/geocoding/v3/?";
            Map<String, String> paramsMap = new LinkedHashMap<>();
            paramsMap.put("address", address);
            paramsMap.put("output", "json");
            paramsMap.put("ak", ak);
            String sn = SnCalUtil.getSn(httpUrl, paramsMap, sk);
            paramsMap.put("sn", sn);
            String paramString = SnCalUtil.toQueryString(paramsMap);
            httpUrl = httpUrl + paramString;
            return ResultObj.success("获取经纬度成功", loadJSON2(httpUrl, address));
        } catch (Exception e) {
            logger.error("获取经纬度失败", e);
            return ResultObj.error("获取经纬度失败");
        }

    }
}
