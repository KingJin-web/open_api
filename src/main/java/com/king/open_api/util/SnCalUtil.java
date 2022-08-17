package com.king.open_api.util;


import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author: King
 * @project: open_api
 * @date: 2021年06月19日 11:32
 * @description: 工具类
 */
public class SnCalUtil {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SnCalUtil.class);

    public SnCalUtil() {
    }

    /**
     * 计算sn跟参数对出现顺序有关（参数对放入顺序必须跟请求中对应参数的出现顺序保持一致）：
     * get请求请使用LinkedHashMap保存<key,value>，该方法根据key的插入顺序排序；
     * post请使用TreeMap保存<key,value>，该方法会自动将key按照字母a-z顺序排序。
     * 所以get请求可自定义参数顺序（sn参数必须在最后）发送请求，
     * 但是post请求必须按照字母a-z顺序填充body（sn参数必须在最后）。
     *
     * @param url       请求路径url
     * @param paramsMap 请求参数对
     * @param sk        ak对应sk秘钥
     * @return sn签名
     * @throws UnsupportedEncodingException
     */
    public static String getSn(String url, Map<?, ?> paramsMap, String sk) throws UnsupportedEncodingException {
        String paramsStr = toQueryString(paramsMap);
        url = url.replaceFirst("http://api.map.baidu.com", "").trim();
        url = url.replaceFirst("http://yingyan.baidu.com", "").trim();

//        logger.info("************************Calculate Sn >>>>>url：{}", url);
        //url在计算sn签名的时候，不管是get请求还是post请求，必须带?
        String wholeStr = url + paramsStr + sk;
        // logger.info("************************Calculate Sn >>>>>wholeStr：" + wholeStr);
        //对上面wholeStr再作utf8编码
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        // logger.info("************************Calculate Sn >>>>>tempStr：{}", tempStr);
        //调用下面的MD5方法得到最后的sn签名
        //        System.out.println("************************Calculate Sn >>>>>Sn：" + sn);
        return MD5(tempStr);
    }

    /**
     * 对请求参数Map内所有value作utf8编码，拼接返回结果
     *
     * @param data 请求参数对
     * @return str 字符串
     * @throws UnsupportedEncodingException 异常
     */
    public static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey()).append("=");
            String ss[] = String.valueOf(pair.getValue()).split(",");
            if (ss.length > 1) {
                for (String s : ss) {
                    queryString.append(URLEncoder.encode(s, "UTF-8")).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                queryString.append("&");
            } else {
                queryString.append(URLEncoder.encode(String.valueOf(pair.getValue()), "UTF-8"));
                queryString.append("&");
            }
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    /**
     * 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
     *
     * @param str 要计算的字符串
     * @return sn
     */
    public static String MD5(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return null;
    }
}

