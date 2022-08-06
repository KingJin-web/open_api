package com.king.open_api.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.vo.ResultObj;
import com.king.open_api.vo.TodayInHistory;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月05日 21:42
 * @description: 历史上的今天服务实现类
 */
@Service
public class TodayInHistoryServiceImpl {

    Logger logger = org.slf4j.LoggerFactory.getLogger(TodayInHistoryServiceImpl.class);

    //获取历史上的今天信息
    public ResultObj getTodayInHistory() {
        try {
            LocalDate localDate = LocalDate.now();
            String month = localDate.getMonthValue() < 10 ? "0" + localDate.getMonthValue() : localDate.getMonthValue() + "";
            String day = localDate.getDayOfMonth() < 10 ? "0" + localDate.getDayOfMonth() : localDate.getDayOfMonth() + "";
            return getTodayInHistory(month + "-" + day);
        } catch (Exception e) {
            e.printStackTrace();
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
            String[] dateArray = date.split("-");
            String month = dateArray[0];
            String day = dateArray[1];
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
                logger.info("历史上的今天信息：{}", todayInHistory);
                todayInHistoryList.add(todayInHistory);
            }
            return ResultObj.success(todayInHistoryList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("获取历史上的今天信息失败");
        }

    }
}