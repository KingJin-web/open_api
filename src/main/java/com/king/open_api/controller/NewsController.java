package com.king.open_api.controller;

import com.king.open_api.entity.MingYan;
import com.king.open_api.service.NewsApiServiceImpl;
import com.king.open_api.vo.ResultObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: King
 * @project: vibrator-spider
 * @date: 2022年07月25日 13:42
 * @description:
 */
@RestController
@RequestMapping("/api/news")
@Api(value = "新闻api", tags = "新闻api")
public class NewsController {
    private NewsApiServiceImpl newsApiService;

    @Autowired
    public void setNewsApiService(NewsApiServiceImpl newsApiService) {
        this.newsApiService = newsApiService;
    }

    @GetMapping("/getNews.do")
    @ApiOperation(value = "获取20条热点新闻", notes = "获取20条热点新闻")
    public ResultObj getNews() {
        return newsApiService.getNewsBySize2(20);
    }

    @GetMapping("/getNewsBySize.do")
    @ApiImplicitParam(name = "size", value = "要获取的新闻数量最大50", required = true, dataType = "Integer",
            defaultValue = "10",dataTypeClass = Integer.class)
    public ResultObj getNewsBySize(Integer size) {
        return newsApiService.getNewsBySize2(size);
    }

    //每日一句
    @ApiOperation(value = "每日一句", notes = "每日一句")
    @GetMapping("/getMingYan.do")
    public ResultObj getMingYan() {
        return ResultObj.success(MingYan.getRandomMingYan());
    }

    //疯狂星期四
    @ApiOperation(value = "疯狂星期四", notes = "疯狂星期四")
    @GetMapping("/getKfc.do")
    public ResultObj getKfc() {
        return ResultObj.success(MingYan.getKfc());
    }

    @ApiOperation(value = "今日小提示", notes = "今日小提示")
    @GetMapping("/getWeekTips.do")
    public ResultObj getWeekTips() {
        return ResultObj.success(MingYan.getWeekTips());
    }

}