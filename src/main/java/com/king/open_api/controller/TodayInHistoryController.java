package com.king.open_api.controller;

import com.king.open_api.service.TodayInHistoryServiceImpl;
import com.king.open_api.vo.ResultObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月05日 23:41
 * @description:
 */
@RestController
@RequestMapping("/api/todayInHistory")
@Api(value = "历史上的今天", tags = "历史上的今天")
public class TodayInHistoryController {

    private TodayInHistoryServiceImpl todayInHistoryService;

    @Autowired
    public TodayInHistoryController(TodayInHistoryServiceImpl todayInHistoryService) {
        this.todayInHistoryService = todayInHistoryService;
    }

    @ApiOperation(value = "获取历史上的今天", notes = "获取历史上的今天")
    @GetMapping("/getTodayInHistory.do")
    public ResultObj getTodayInHistory() {
        return todayInHistoryService.getTodayInHistory();
    }

    @ApiOperation(value = "获取历史上的指定日期的今天 格式MM-DD", notes = "获取历史上的指定日期的今天  格式MM-DD")
    @GetMapping("/getTodayInHistoryByDate.do")
    public ResultObj getTodayInHistoryByDate(String date) {

        return todayInHistoryService.getTodayInHistory(date);

    }

}