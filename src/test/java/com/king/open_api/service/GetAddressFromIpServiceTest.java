package com.king.open_api.service;

import com.king.open_api.entity.IPEntryCN;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class GetAddressFromIpServiceTest {

    @Autowired
    private GetAddressFromIpService getAddressFromIpService;
    @Test
    public void getAddressFromIp() {
    }

    @Test
    public void testGetAddressFromIp() {
        String ip = "117.143.125.183";
        String address = getAddressFromIpService.getAddressFromIp(ip,"taobao");
        System.out.println(address);
    }

    @Test
    public void getAddressFromIpTaoBao() {
    }

    @Test
    public void getAddressFromIpCz88() {
    }
}