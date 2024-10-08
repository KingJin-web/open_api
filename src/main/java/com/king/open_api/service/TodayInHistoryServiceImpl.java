package com.king.open_api.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.vo.ResultObj;
import com.king.open_api.vo.TodayInHistory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.*;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月05日 21:42
 * @description: 历史上的今天服务实现类
 */
@Service
public class TodayInHistoryServiceImpl {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TodayInHistoryServiceImpl.class);
    private static String unicodeToChinese(String unicodeStr) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int length = unicodeStr.length();
        while (++i < length) {
            int codePoint = 0;
            char c = unicodeStr.charAt(i);
            if (c == '\\') {
                if (i < length - 5 && unicodeStr.charAt(i + 1) == 'u') {
                    codePoint = Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16);
                    sb.append((char) codePoint);
                    i += 5;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //获取历史上的今天信息
    public ResultObj getTodayInHistoryByDate(String date) {
        try {
            //指定格式为 MM-DD
            if (ObjectUtils.isEmpty(date) || date.length() != 5) {
                return ResultObj.error("日期格式不正确");
            }

            String date1[] = date.split("-");
            // 时间戳

            String url = "https://baike.baidu.com/cms/home/eventsOnHistory/" + date1[0] + ".json?_=" + System.currentTimeMillis();
            // 第二步，发送请求，获取响应，响应内容为json字符串
            String json = HttpUtils.get(url);
            JSONObject jsonObject = JSON.parseObject(json);
            //获取指定期限的信息
            JSONArray jsonArray = jsonObject.getJSONObject(date1[0]).getJSONArray(date1[0] + date1[1]);

            //System.out.println(unicodeToChinese(jsonArray.toJSONString()));
            List<TodayInHistory> todayInHistoryList = new LinkedList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject elementJO = jsonArray.getJSONObject(i);
                TodayInHistory todayInHistory = new TodayInHistory();
                todayInHistory.setYear(elementJO.get("year").toString());
                todayInHistory.setTitle(HttpUtils.delHTMLTag(elementJO.get("title").toString()));
                todayInHistory.setFestival(elementJO.get("festival").toString());
                todayInHistory.setLink(elementJO.get("link").toString());
                todayInHistory.setDesc(HttpUtils.delHTMLTag(elementJO.get("desc").toString()));
                todayInHistoryList.add(todayInHistory);
            }



            return ResultObj.success(todayInHistoryList.size(), todayInHistoryList);
        } catch (Exception e) {
            logger.error("获取历史上的今天信息异常", e);
            return ResultObj.error("获取历史上的今天信息失败");
        }
    }

    public ResultObj getTodayInHistory() {
        try {
            LocalDate localDate = LocalDate.now();
            //MM-dd 例如 08-05
            String day = String.format("%02d", localDate.getDayOfMonth());
            String month = String.format("%02d", localDate.getMonthValue());
            return getTodayInHistoryByDate(month + "-" + day);
        } catch (Exception e) {
            logger.error("获取历史上的今天信息异常", e);
            return ResultObj.error("获取历史上的今天信息失败");
        }
    }

    /**
     * 获取历史上的今天信息
     *
     * @param date MM-dd 例如 08-05
     * @return
     */
    public ResultObj getTodayInHistory(String date) {
        try {
            // 第一步，获取月份和日期
            if (ObjectUtils.isEmpty(date) || date.length() != 5) {
                return ResultObj.error("日期格式不正确");
            }
            //判断输入的日期是否存在
            String[] dateArray;
            String month;
            String day;
            try {
                dateArray = date.split("-");
                month = dateArray[0];
                day = dateArray[1];
                LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(month), Integer.parseInt(day));
            } catch (Exception e) {
                logger.error("输入的日期不正确");
                return ResultObj.error("输入的日期不正确");
            }
            // 时间戳
            long timestamp = System.currentTimeMillis();
            String url = "https://baike.baidu.com/cms/home/eventsOnHistory/" + month + ".json?_=" + timestamp;
            // 第二步，发送请求，获取响应，响应内容为json字符串
            String json = HttpUtils.getBaiduToDayHistory(url);
            JSONObject jsonObject = JSON.parseObject(json);
            List<TodayInHistory> todayInHistoryList = new LinkedList<>();
            JSONArray jsonArray = JSON.parseObject(jsonObject.getString(month)).getJSONArray(month + day);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject elementJO = jsonArray.getJSONObject(i);
                TodayInHistory todayInHistory = new TodayInHistory();
                todayInHistory.setYear(elementJO.get("year").toString());
                todayInHistory.setTitle(HttpUtils.delHTMLTag(elementJO.get("title").toString()));
                todayInHistory.setFestival(elementJO.get("festival").toString());
                todayInHistory.setLink(elementJO.get("link").toString());
                todayInHistory.setDesc(HttpUtils.delHTMLTag(elementJO.get("desc").toString()));
                todayInHistoryList.add(todayInHistory);
            }

            return ResultObj.success(todayInHistoryList.size(), todayInHistoryList);
        } catch (Exception e) {
            logger.error("获取历史上的今天信息失败", e);
            return ResultObj.error("获取历史上的今天信息失败");
        }

    }
}