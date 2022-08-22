package com.king.open_api.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.entity.IPEntryCN;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.ResultObj;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: King
 * @project: springboot
 * @date: 2022年07月27日 04:00
 * @description:
 */
@Service
public class GetAddressFromIpService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(GetAddressFromIpService.class);

    private static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php?ip=";

    private static final String IP_URL_TaoBao = "https://ip.taobao.com/outGetIpInfo?accessKey=alibaba-inc&ip=%s";
    private static final String IP_URL_TEST = "http://ip-api.com/json/IP?lang=zh-CN";

    //百度IP地址查询接口
    private static final String IP_URL_BAIDU = "http://opendata.baidu.com/api.php?query=IP&co=&resource_id=6006&oe=utf8";

    private static final String IP_URL_CZ88 = "https://www.cz88.net/api/cz88/ip/base?ip=%s";

    public ResultObj getAddressFromIp(String ip) {
        try {
            return ResultObj.success(getIPEntryCNFromIp(ip));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取IP地址信息失败");
        }

    }

    public IPEntryCN getIPEntryCNFromIp(String ip) {
        IPEntryCN ipEntryCN = new IPEntryCN();
        try {
            ipEntryCN = getAddressFromIpCZ88(ip);
            if (StringUtils.isEmpty(ipEntryCN.getCountry())) {
                ipEntryCN = getAddressFromIpBaidu(ip);
            }
            return ipEntryCN;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipEntryCN;

    }

    private IPEntryCN getAddressFromIpBaidu(String ip) {
        String url = String.format(IP_URL_CZ88, ip);
        String result = HttpUtils.get(url);
        return getAddressFromIpTaoBaoJson(result);

    }

    public String getAddressFromIp(String ip, String type) {
        //替换IP_URL_TEST中的IP为客户端传入的IP
        String url = "";
        if ("taobao".equals(type)) {
            url = String.format(IP_URL_TaoBao, ip);
        } else if ("baidu".equals(type)) {
            url = IP_URL_BAIDU.replace("IP", ip);
        } else {
            url = IP_URL_TEST.replace("IP", ip);
        }
        url = String.format(IP_URL_TaoBao, ip);
        logger.info("url={}", url);
        String result = HttpUtil.get(url);
        logger.info("result={}", result);

        return result;
    }

    public IPEntryCN getAddressFromIpTaoBao(String ip) {
        String url = String.format(IP_URL_TaoBao, ip);
        String result = HttpUtil.get(url);
        System.out.println(result);
        return null;
    }

    public IPEntryCN getAddressFromIpCZ88(String ip) {
        String url = String.format(IP_URL_CZ88, ip);
        Map<String, String> headers = new HashMap<>();
        headers.put("authority", "www.cz88.net");
        headers.put("method", "GET");
        headers.put("path", "/api/cz88/ip/base?ip=" + ip);
        headers.put("accept", "application/json, text/plain, */*");
        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("accept-language", "zh-CN,zh;q=0.9");
        String result = HttpUtils.getRandomUserAgent(url, headers);

        //解析json
        JSONObject jsonObject = JSON.parseObject(result);
        IPEntryCN ipEntryCN = new IPEntryCN();
        if (!jsonObject.get("code").equals(200)) {
            return ipEntryCN;
        }
        JSONObject data = jsonObject.getJSONObject("data");
        ipEntryCN.setCountry(data.getString("country"));
        ipEntryCN.setRegion(data.getString("province"));
        ipEntryCN.setCity(data.getString("city"));
        ipEntryCN.setDistricts(data.getString("districts"));
        ipEntryCN.setIsp(data.getString("isp"));
        ipEntryCN.setIp(data.getString("ip"));
        ipEntryCN.setCountry_id(data.getString("countryCode"));
        return ipEntryCN;
    }
    
    /**
     * 纯真IP地址查询接口
     *
     * @param ip
     * @return
     */
    public IPEntryCN getAddressFromIpCz88(String ip) {
        IPSeekerServiceImpl ipSeekerService = IPSeekerServiceImpl.getInstance();
        IPEntryCN ipEntryCN = new IPEntryCN();
        ipEntryCN.setQueryIp(ip);
        ipEntryCN.setCountry(ipSeekerService.getCountry(ip));
        ipEntryCN.setCity(ipSeekerService.getArea(ip));
        ipEntryCN.setRegion(ipSeekerService.getAddress(ip));
        return ipEntryCN;
    }


    //解析TaoBao JSON
    public IPEntryCN getAddressFromIpTaoBaoJson(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject.getInteger("code") == 0) {
            JSONObject data = jsonObject.getJSONObject("data");
            data.to(IPEntryCN.class);
            return data.to(IPEntryCN.class);
        }
        return null;
    }

}