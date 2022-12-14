package com.king.open_api.controller;

import com.king.open_api.service.NewsApiServiceImpl;
import com.king.open_api.vo.ResultObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
    public ResultObj getNews() {
        return newsApiService.getNews();
    }

    @GetMapping("/getNewsBySize.do")
    @ApiImplicitParam(name = "size", value = "要获取的新闻数量", required = true, dataType = "Integer",
            defaultValue = "10",dataTypeClass = Integer.class)
    public ResultObj getNewsBySize(Integer size) {
        return newsApiService.getNewsBySize(size);
    }


}