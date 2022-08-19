package com.king.open_api.service;


import com.king.open_api.vo.ResultObj;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
public class LBSServiceImplTest {

    @Autowired
    LBSServiceImpl lbsService;

    @Test
    public void getLngLat() {
        String address = "湖南省常德市临澧县佘市桥镇大观村";
        address = "上海市浦东新区世纪大道";
        address = "北京市海淀区上地十街10号";
        ResultObj lngLat = lbsService.getLngLat(address);
        System.out.println(lngLat);
    }
}