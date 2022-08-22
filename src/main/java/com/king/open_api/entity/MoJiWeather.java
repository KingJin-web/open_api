package com.king.open_api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: King
 * @project: springboot
 * @date: 2022年07月27日 11:14
 * @description:
 */
@Data
public class MoJiWeather {
    private Integer code;
    private String msg;
    private WeatherData data;

    @Data
    public static class WeatherData {
        private Integer total;
        private String sourceName;
        private String logoUrl;
        private List<Weather> list;
    }

    @Data
    public static class Weather {
        @ApiModelProperty(value = "城市")
        private String city;
//        private String lastUpdateTime;
//        private String date;
//        private String weather;
//        private String temp;
//        private String humidity;
//        private String wind;
//        private String pm25;
//        private String pm10;
//        private String low;
//        private String high;
//        private String airData;
//        private String airQuality;
//        private long dateLong;
//        private int weatherType;
//        private int windLevel;
//        private String province;
//        private String moreData;
        @ApiModelProperty(value = "上次更新时间")
        private String lastUpdateTime;
        @ApiModelProperty(value = "日期")
        private String date;
        @ApiModelProperty(value = "天气")
        private String weather;
        @ApiModelProperty(value = "温度")
        private String temp;
        @ApiModelProperty(value = "湿度")
        private String humidity;
        @ApiModelProperty(value = "风力")
        private String wind;
        @ApiModelProperty(value = "PM2.5")
        private String pm25;
        @ApiModelProperty(value = "PM10")
        private String pm10;
        @ApiModelProperty(value = "最低温度")
        private String low;
        @ApiModelProperty(value = "最高温度")
        private String high;
        @ApiModelProperty(value = "空气质量")
        private String airData;
        @ApiModelProperty(value = "空气质量指数")
        private String airQuality;
        @ApiModelProperty(value = "日期long")
        private long dateLong;
        @ApiModelProperty(value = "天气类型")
        private int weatherType;
        @ApiModelProperty(value = "风力等级")
        private int windLevel;
        @ApiModelProperty(value = "省份")
        private String province;
        @ApiModelProperty(value = "预警信息")
        private String moreData;    }

    @Data
    public static class MoreData {
        private String sunrise;
        private String sunset;
        private String precipitation;
        private List<Alert> alert;
    }

    @Data
    public static class Alert {
        private String update_time;
        private int infoid;
        private String level;
        private String pub_time;
        private String name;
        private String title;
        private String type;
        private String content;
    }
}