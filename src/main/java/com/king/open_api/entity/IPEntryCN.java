package com.king.open_api.entity;

import lombok.Data;

/**
 * @author: King
 * @project: springboot
 * @date: 2022年07月27日 04:10
 * @description:
 */
@Data
public class IPEntryCN {


//"status": "success",
//        "country": "中国",
//        "countryCode": "CN",
//        "region": "HN",
//        "regionName": "湖南",
//        "city": "常德",
//        "zip": "",
//        "lat": 29.0354,
//        "lon": 111.6971,
//        "timezone": "Asia/Shanghai",
//        "isp": "China Mobile communications corporation",
//        "org": "China Mobile",
//        "as": "AS56047 China Mobile communications corporation",
//        "query": "120.227.93.113"

//   "area": "",
//           "country": "中国",
//           "isp_id": "100017",
//           "queryIp": "113.240.245.242",
//           "city": "长沙",
//           "ip": "113.240.245.242",
//           "isp": "电信",
//           "county": "",
//           "region_id": "430000",
//           "area_id": "",
//           "county_id": null,
//           "region": "湖南",
//           "country_id": "CN",
//           "city_id": "430100"
    private String area;
    private String country;
    private String isp_id;
    private String queryIp;
    private String city;
    private String ip;
    private String isp;
    private String county;
    private String region_id;
    private String area_id;
    private String county_id;
    private String region;
    private String country_id;
    private String city_id;
    private String districts;



}