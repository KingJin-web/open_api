package com.king.open_api.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.util.SnCalUtil;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.MapVo;
import com.king.open_api.vo.ResultObj;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Exception
 * @date: 2022-08-15-9:37
 * @description
 */
@Service
public class BaiduApiServiceImpl {


    Logger logger = org.slf4j.LoggerFactory.getLogger(BaiduApiServiceImpl.class);

    @Value("${baiduApi.ak}")
    private String ak;
    @Value("${baiduApi.sk}")
    private String sk;


    /**
     * 加载JSON数据
     *
     * @param url
     * @return
     * @throws IOException
     */
    public MapVo loadJSON2(String url, String address) {
        String param = HttpUtils.get(url);
        JSONObject jsonObject = JSON.parseObject(param);
        if (jsonObject.getInteger("status") == 0) {
            //经纬度
            JSONObject location = jsonObject.getJSONObject("result").getJSONObject("location");
            String lng = location.getString("lng");
            String lat = location.getString("lat");
            return new MapVo(address, lng, lat);
        } else {
            logger.error("获取经纬度失败，错误码：{}，错误信息：{}", jsonObject.getInteger("status"), jsonObject.getString("message"));
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
            return getResultObj(address, httpUrl, paramsMap);
        } catch (Exception e) {
            logger.error("获取经纬度失败", e);
            return ResultObj.error("获取经纬度失败");
        }

    }

    //https://api.map.baidu.com/location/ip?ak=您的AK&ip=您的IP&coor=bd09ll //GET请求
    public ResultObj getLngLatByIp(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return ResultObj.error("ip不能为空");
        }
        try {
            logger.info("getLngLatByIp ip:{}", ip);
            String httpUrl = "https://api.map.baidu.com/location/ip?";
            Map<String, String> paramsMap = new LinkedHashMap<>();
            paramsMap.put("ak", ak);
            paramsMap.put("ip", ip);
            paramsMap.put("coor", "bd09ll");
            return getResultObj(ip, httpUrl, paramsMap);
        } catch (Exception e) {
            logger.error("获取经纬度失败", e);
            return ResultObj.error("获取经纬度失败");
        }

    }

    @NotNull
    private ResultObj getResultObj(String ip, String httpUrl, Map<String, String> paramsMap) throws UnsupportedEncodingException {
        String sn = SnCalUtil.getSn(httpUrl, paramsMap, sk);
        paramsMap.put("sn", sn);
        String paramString = SnCalUtil.toQueryString(paramsMap);
        httpUrl = httpUrl + paramString;
        MapVo mapVo = loadJSON2(httpUrl, ip);
        return ResultObj.success("获取经纬度成功", mapVo);
    }
}
