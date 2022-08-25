package com.king.open_api.service;

import com.king.open_api.util.HttpUtils;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
public class GetHotNewsServiceImplTest {

    @Autowired
    GetHotNewsServiceImpl getHotNewsService;
    @Test
    public void test(){
//        val douYinHotNews2 = getHotNewsService.getDouYinHotNews2();
//        System.out.println(douYinHotNews2);

        String s = (String) getHotNewsService.grabHotNews3(20).getData();
        System.out.println(s);
        Map<String, Object> map = new HashMap<>();
        map.put("data", s);
        System.out.println(HttpUtils.post("http://39.103.201.131/image",map));
    }
}