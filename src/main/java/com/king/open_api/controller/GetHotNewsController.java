package com.king.open_api.controller;

import com.king.open_api.service.GetHotNewsServiceImpl;
import com.king.open_api.util.StringUtils;
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
 * @date: 2022年07月28日 10:15
 * @description:
 */
@RestController
@RequestMapping("/api/hotnews")
@Api(value = "热点新闻", tags = "热点新闻")
public class GetHotNewsController {
    private final GetHotNewsServiceImpl getHotNewsService;


    @Autowired
    public GetHotNewsController(GetHotNewsServiceImpl getHotNewsService) {
        this.getHotNewsService = getHotNewsService;
    }

    //获取微博热搜
    @ApiOperation(value = "获取微博热搜", notes = "获取微博热搜")
    @GetMapping("/getWeiboHotNews.do")
    public ResultObj getWeiboHotNews() {
        try {
            return ResultObj.success(getHotNewsService.grabWeiBoHotNews2());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取微博热搜失败");
        }
    }

    @ApiOperation(value = "获取百度热搜", notes = "获取百度热搜")
    @GetMapping("/getBaiduHotNews.do")
    public ResultObj getBaiduHotNews() {
        try {
            return ResultObj.success(getHotNewsService.grabBaiduHotNews2());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取百度热搜失败");
        }
    }

    @ApiOperation(value = "获取热搜组合版", notes = "获取热搜组合版")
    @ApiImplicitParam(name = "size", value = "获取热搜的数量", required = true, dataType = "Integer",
            dataTypeClass = Integer.class, paramType = "query")
    @GetMapping("/getHotNews.do")
    public ResultObj getHotNews(Integer size) {
        try {
            if (StringUtils.isEmpty(size)) {
                return ResultObj.error("请输入获取热搜的数量");
            }
            return ResultObj.success(getHotNewsService.grabHotNews2(size));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取热搜组合版失败");
        }
    }

    @ApiOperation(value = "获取抖音热搜", notes = "获取抖音热搜")
    @GetMapping("/getDouYinHotNews.do")
    public ResultObj getDouYinHotNews() {
        try {
            return ResultObj.success(getHotNewsService.getDouYinHotNews2());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取抖音热搜失败");
        }
    }

    @ApiOperation(value = "获取热搜", notes = "获取热搜")
    @GetMapping("/getAllHotNews.do")
    @ApiImplicitParam(name = "size", value = "获取热搜的数量", required = true, dataType = "Integer", dataTypeClass = Integer.class, paramType = "query")
    public ResultObj getAllHotNews(Integer size) {
        try {
            return getHotNewsService.grabHotNews3(size);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取热搜失败");
        }
    }

}