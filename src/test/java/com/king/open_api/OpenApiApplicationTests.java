package com.king.open_api;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class OpenApiApplicationTests {

    @Test
    public void contextLoads() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

        LocalDate localDate = LocalDate.parse("08-05", formatter);
        System.out.println(localDate);
    }

    @Test
    public void test() {
        //:authority: mcs.zijieapi.com
        //:method: POST
        //:path: /list
        //:scheme: https
        //accept: */*
        //accept-encoding: gzip, deflate, br
        //accept-language: zh-CN,zh;q=0.9
        //content-length: 1783
        Map<String, String> map = new HashMap<>();
        map.put("authority","");

        String s = HttpUtils.get("https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/?reflow_source=reflow_page");

        JSONArray jsonArray = JSON.parseObject(s).getJSONArray("word_list");

        System.out.println(s);
    }

}
