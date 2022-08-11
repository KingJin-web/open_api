package com.king.open_api.service;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class GetHotNewsServiceImplTest {

    @Autowired
    GetHotNewsServiceImpl getHotNewsService;
    @Test
    public void test(){
        val douYinHotNews2 = getHotNewsService.getDouYinHotNews2();
        System.out.println(douYinHotNews2);

    }
}