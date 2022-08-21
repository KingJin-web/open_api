package com.king.open_api.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月20日 12:59
 * @description:
 */
@Controller
public class MvcController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(MvcController.class);

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