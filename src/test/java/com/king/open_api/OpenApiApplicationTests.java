package com.king.open_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class OpenApiApplicationTests {

    @Test
    void contextLoads() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

        LocalDate localDate = LocalDate.parse("08-05", formatter);
        System.out.println(localDate);
    }

}
