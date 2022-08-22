package com.king.open_api.controller;

import com.king.open_api.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "返回新闻模板", notes = "返回新闻模板")
    @GetMapping("/getNewsModel.do")
    public NewsModel getReturnModel() {
        return new NewsModel();
    }

    @ApiOperation(value = "历史上的今天模板", notes = "历史上的今天模板")
    @GetMapping("/getTodayInHistory.do")
    public TodayInHistory getTodayInHistory() {
        return new TodayInHistory();
    }

    @ApiOperation(value = "天气模板", notes = "天气模板")
    @GetMapping("/getWeatherVo.do")
    public WeatherVo getWeatherVo() {
        return new WeatherVo();
    }

    @ApiOperation(value = "ip信息模板", notes = "ip信息模板 ")
    @GetMapping("/getIpVo.do")
    public IpVo getIpVo() {
        return new IpVo();
    }

    @ApiOperation(value = "地图信息模板", notes = "地图信息模板")
    @GetMapping("/getMapVo.do")
    public MapVo getMapVo() {
        return new MapVo();
    }


    @GetMapping("/getResultObj.do")
    public ResultObj getResultObj() {
        return new ResultObj();
    }

}