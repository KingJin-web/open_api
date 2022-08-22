package com.king.open_api.controller;

import com.king.open_api.util.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月19日 22:51
 * @description: 随机api
 */
@RestController
@RequestMapping("/api/random")
@Api(value = "随机api", tags = "随机api")
public class RandomController {
    /**
     * 大写字母(A-Z)   小写字母(a-z)   数字(0-9)   其他符号(~!@#$%^&*()-+_=,.)
     *
     * @param length
     * @return
     */
    @ApiOperation(value = "生成随机字符串", notes = "生成随机字符串")
    @GetMapping("/getRandomString.do")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "length", value = "随机字符串长度 须大于0小于1000 如果小于等于0 则默认为10 ", required = false,
                    dataType = "int", defaultValue = "10", paramType = "query", dataTypeClass = String.class, example = "10",
                    allowableValues = "range[1,1000]"),
            @ApiImplicitParam(name = "isUpperCase", value = "是否有大写字母(A-Z)", required = false,
                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true"),
            @ApiImplicitParam(name = "isLowerCase", value = "是否有小写字母(a-z) ", required = false,
                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true"),
            @ApiImplicitParam(name = "isNumber", value = "是否有数字(0-9)", required = false,
                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true"),
            @ApiImplicitParam(name = "isOther", value = "是否有其他符号(~!@#$%^&*()-+_=,.)", required = false,
                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true")
    })
    public String getRandomString(Integer length, Boolean isUpperCase, Boolean isLowerCase, Boolean isNumber, Boolean isOther) {
        return RandomUtils.getRandomString(length, isUpperCase, isLowerCase, isNumber, isOther);
    }


    @ApiOperation(value = "生成随机姓名", notes = "生成随机姓名")
    @GetMapping("/getRandomName.do")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "isMale", value = "是否男性", required = false,
//                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true"),
//            @ApiImplicitParam(name = "isFemale", value = "是否女性", required = false,
//                    dataType = "Boolean", defaultValue = "true", dataTypeClass = Boolean.class, example = "true")
//    })
    public String getRandomName(Boolean isMale, Boolean isFemale) {
        return RandomUtils.getRandomName(isMale, isFemale);
    }

}