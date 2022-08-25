package com.king.open_api.controller;

import com.king.open_api.util.IPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.slf4j.Logger;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
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
public class MvcController implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 1024));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", webSocketDeploymentInfo);
        });
    }

    @ApiOperation(value = "", hidden = true)
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        //重定向到首页
        try {
            String ip = IPUtils.getIPAddress(request);
            //request.getRequestDispatcher("/跳转地址").forward(request,response);
            response.sendRedirect("http://api.wuzhaoqi.top/index.html?ip=" + ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}