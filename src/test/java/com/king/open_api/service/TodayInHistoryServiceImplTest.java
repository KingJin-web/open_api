//package com.king.open_api.service;
//
//import cn.hutool.http.HttpRequest;
//import com.king.open_api.vo.TodayInHistory;
//import org.jsoup.Jsoup;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.*;
//
//import static org.junit.Assert.*;
//
//@SpringBootTest
//public class TodayInHistoryServiceImplTest {
//
//    @Test
//    public void getTodayInHistory() {
//        // 第一步，拼接URL
//        String url = "https://www.baidu.com/s?ie=UTF-8&wd=历史上的今天";
//        // 设置请求头
//        Map<String, String> headers = new HashMap<>();
//        headers.put("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
//
//        // 第二步，发送请求，获取响应，响应内容为html源码内容
//        String htmlContent = HttpRequest.get(url).headerMap(headers, true).execute().body();
//
//        // 第三步，提取html源码中的有效信息，是json字符串隐藏在注释中
//        int beginIndex = htmlContent.indexOf("<!--s-data:") + 11;
//        int endIndex = htmlContent.indexOf("true}-->") + 5;
//        String jsonContent = htmlContent.substring(beginIndex, endIndex);
//
//        // 第四步，使用Gson解析json字符串
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);
//        String today = jsonObject.get("date").getAsString();
//        JsonArray cardList = jsonObject.get("cardList").getAsJsonArray();
//        if (!cardList.isJsonNull() && cardList.size() > 0) {
//            for (JsonElement jsonElement : cardList) {
//                // 提取json字符串中的有效信息
//                JsonObject card = jsonElement.getAsJsonObject();
//                String yearTag = card.get("yearTag").getAsString();
//                String baikeUrl = card.get("url").getAsString();
//                String title = card.get("title").getAsString();
//                String textTip = card.get("textTip").getAsString();
//                String text = card.get("text").getAsString();
//                String image = card.get("image").getAsString();
//                System.out.println(yearTag + "\t\t" + baikeUrl + "\t\t" + title + "\t\t" + textTip + "\t\t" + text + "\t\t" + image);
//            }
//        }
//    }
//
//    Logger logger = org.slf4j.LoggerFactory.getLogger(TodayInHistoryServiceImplTest.class);
//
//    @Autowired
//    private TodayInHistoryServiceImpl todayInHistoryService;
//    @Test
//    public void test() {
//        /*
//            9月份所有日期在历史上发生的事件集合URL：https://baike.baidu.com/cms/home/eventsOnHistory/09.json?_=1631613042210
//            其中_参数是时间戳，表示当前日期的毫秒值
//            而09表示月份，从01月到12月，分别数字是[01,12]
//         */
//        // 第一步，拼接URL
//        Calendar calendar = Calendar.getInstance();
//        int month = calendar.get(Calendar.MONTH) + 1;// 月份
//        String realMonth = (month < 10) ? "0" + month : month + "";
//        long timestamp = new Date().getTime();// 时间戳
//        String url = "https://baike.baidu.com/cms/home/eventsOnHistory/" + realMonth + ".json?_=" + timestamp;
//        // 设置请求头
//        Map<String, String> headers = new HashMap<>();
//        headers.put("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
//        headers.put("Host", "baike.baidu.com");
//        headers.put("Referer", " https://baike.baidu.com/calendar/");
//
//        // 第二步，发送请求，获取响应，响应内容为json字符串
//        String jsonContent = HttpRequest.get(url).headerMap(headers, true).execute().body();
//
//        // 第三步，使用Gson提取json字符串中的有效信息
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);
//        JsonObject realMonthJO = jsonObject.getAsJsonObject(realMonth);
//        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//        String realTodayOfMonth = realMonth + ((dayOfMonth < 10) ? "0" + dayOfMonth : dayOfMonth + "");// 获取今天在本月中的日期，如本月是11月份，那么就是"1101"、"1102"...
//        // 获取历史上今天所有的事情
//        JsonArray dayOfMonthJA = realMonthJO.getAsJsonArray(realTodayOfMonth);
//        List<TodayInHistory> todayInHistoryList = new ArrayList<>();
//        if (!dayOfMonthJA.isJsonNull() && dayOfMonthJA.size() > 0) {
//            for (JsonElement jsonElement : dayOfMonthJA) {
//                JsonObject elementJO = jsonElement.getAsJsonObject();
//                TodayInHistory todayInHistory = new TodayInHistory();
//                todayInHistory.setYear(elementJO.get("year").getAsString());
//                todayInHistory.setTitle(elementJO.get("title").getAsString());
//                todayInHistory.setFestival(elementJO.get("festival").getAsString());
//                todayInHistory.setLink(elementJO.get("link").getAsString());
//                todayInHistory.setDesc(Jsoup.parse(elementJO.get("desc").getAsString()).body().text());
//                logger.info(todayInHistory.toString());
//                todayInHistoryList.add(todayInHistory);
//            }
//        }
//    }
//
//    @Test
//    public void test1(){
//        logger.info(todayInHistoryService.getTodayInHistory().toString());
//    }
//
//
//
//    @Test
//    void deleteHtmlTags() {
//        //定义字符串
//        String htmlStr = "埃里希·<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E5%85%8B%E8%8E%B1%E4%BC%AF\\\">克莱伯</a>（Erich·Kleiber，1890年8月5日—1956年1月27日），20世纪伟大的<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E6%8C%87%E6%8C%A5\\\">指挥</a>之一，<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E5%8D%A1%E6%B4%9B%E6%96%AF%C2%B7%E5%85%8B%E8%8E%B1%E4%BC%AF\\\">卡洛斯·克莱伯</a>之父；1890年出生在<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E5%A5%A5%E5%9C%B0%E5%88%A9\\\">奥地";
//        //定义script的正则表达式，去除js可以防止注入
//        String scriptRegex = "<script[^>]*?>[\\s\\S]*?<\\/script>";
//        //定义style的正则表达式，去除style样式，防止css代码过多时只截取到css样式代码
//        String styleRegex = "<style[^>]*?>[\\s\\S]*?<\\/style>";
//        //定义HTML标签的正则表达式，去除标签，只提取文字内容
//        String htmlRegex = "<[^>]+>";
//        //定义空格,回车,换行符,制表符
//        String spaceRegex = "\\s*|\t|\r|\n";
//        // 过滤script标签
//        htmlStr = htmlStr.replaceAll(scriptRegex, "");
//        // 过滤style标签
//        htmlStr = htmlStr.replaceAll(styleRegex, "");
//        // 过滤html标签
//        htmlStr = htmlStr.replaceAll(htmlRegex, "");
//        // 过滤空格等
//        htmlStr = htmlStr.replaceAll(spaceRegex, "");
//        // 过滤&nbsp;
//        htmlStr = htmlStr.replace("&nbsp;", "");
//        // 过滤&nbsp
//        htmlStr = htmlStr.replace("&nbsp", "");
//        // 返回文本字符串
//        htmlStr = htmlStr.trim();
//        //去除空格" "
//        htmlStr = htmlStr.replaceAll(" ", "");
//        System.out.println(htmlStr);
//    }
//}