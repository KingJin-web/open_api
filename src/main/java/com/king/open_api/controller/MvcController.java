package com.king.open_api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月20日 12:59
 * @description:
 */
@Controller
@ApiIgnore
public class MvcController {

    @ApiOperation(value = "", hidden = true)
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        //重定向到首页
        try {
            response.sendRedirect("/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}