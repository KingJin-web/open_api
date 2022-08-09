package com.king.open_api.controller;

import com.king.open_api.vo.NewsModel;
import com.king.open_api.vo.TodayInHistory;
import com.king.open_api.vo.WeatherVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月08日 00:05
 * @description:
 */
@RestController
@RequestMapping("/api/returnModel")
@Api(value = "返回模板", tags = "返回模板")
public class ReturnModelController {

    @GetMapping("/getNewsModel.do")
    public NewsModel getReturnModel() {
        return new NewsModel();
    }

    @GetMapping("/getTodayInHistory.do")
    public TodayInHistory getTodayInHistory() {
        return new TodayInHistory();
    }

    @GetMapping("/getWeatherVo.do")
    public WeatherVo getWeatherVo() {
        return new WeatherVo();
    }


}