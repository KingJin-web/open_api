package com.king.open_api.service;


import com.king.open_api.vo.ResultObj;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class WeatherServiceImplTest {

    @Autowired
    WeatherServiceImpl weatherService;

    @Test
    public void getWeather() {
        ResultObj r = weatherService.getWeatherByAddress("长沙");
        System.out.println(r);
    }
}