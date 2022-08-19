package com.king.open_api.controller;

import com.king.open_api.service.BaiduApiServiceImpl;
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
 * @project: open_api
 * @date: 2022年08月17日 23:43
 * @description:
 */
@RestController
@RequestMapping("/api/address")
@Api(value = "地址", tags = "地址")
public class MapController {


    private final BaiduApiServiceImpl lbsService;

    @Autowired
    public MapController(BaiduApiServiceImpl lbsService) {
        this.lbsService = lbsService;
    }

    /**
     * 根据地址获取经纬度
     */
    @ApiOperation("根据地址获取经纬度")
    @GetMapping("/getLngLat.do")
    @ApiImplicitParam(name = "address", value = "要获取经纬度的地址", required = true,
            dataType = "String", defaultValue = "上海市浦东新区世纪大道")
    public ResultObj getLngLat(String address) {
        return lbsService.getLngLat(address);
    }
}