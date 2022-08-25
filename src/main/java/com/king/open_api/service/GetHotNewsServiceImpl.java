package com.king.open_api.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.entity.WeiBoHot;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.NewsModel;
import com.king.open_api.vo.ResultObj;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author: King
 * @project: vibrator-spider
 * @date: 2022年07月28日 09:39
 * @description: 热搜
 */
@Service
public class GetHotNewsServiceImpl {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GetHotNewsServiceImpl.class);

    /**
     * 抓取百度热点排行榜
     *
     * @return
     */
    public List<NewsModel> grabBaiduHotNews() {
        String url = "https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065";
        List<NewsModel> list = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            //标题
            Elements titles = doc.select(".c-single-text-ellipsis");
            //图片
            Elements imgs = doc.select(".category-wrap_iQLoo .index_1Ew5p").next("img");
            //内容
            Elements contents = doc.select(".hot-desc_1m_jR.large_nSuFU");
            //推荐图
            Elements urls = doc.select(".category-wrap_iQLoo a.img-wrapper_29V76");
            //热搜指数
            Elements levels = doc.select(".hot-index_1Bl1a");
            for (int i = 0; i < levels.size(); i++) {
                NewsModel o = new NewsModel();
                o.setTitle(titles.get(i).text().trim());
                o.setImg(imgs.get(i).attr("src"));
                o.setContent(contents.get(i).text().replaceAll("查看更多>", "").trim());
                o.setUrl(urls.get(i).attr("href"));
//                o.setLevel(levels.get(i).text().trim());
                list.add(o);
            }
            return list;

        } catch (IOException e) {
            logger.error("抓取百度热点排行榜异常：" + e.getMessage());
        }
        return null;
    }

    /**
     * 抓取微博热搜榜
     */
    public List<NewsModel> grabWeiBoHotNews() {
        String url = "https://weibo.com/ajax/statuses/hot_band";
        String s = HttpUtil.get(url);
        WeiBoHot weiBoHot = JSON.parseObject(s, WeiBoHot.class);
        List<NewsModel> list = new ArrayList<>();
        for (WeiBoHot.WeiBo weiBo : weiBoHot.getData().getBand_list()) {
            NewsModel o = new NewsModel();
            o.setTitle(weiBo.getNote());
            o.setImg(weiBo.getMblog());
            o.setContent(weiBo.getWord());
            o.setUrl(weiBo.getWord_scheme());
            list.add(o);
        }
        return list;
    }

    public String grabWeiBoHotNews2() {
        String url = "https://weibo.com/ajax/statuses/hot_band";

        String s = HttpUtil.get(url);
        System.out.println(s);
        WeiBoHot weiBoHot = JSON.parseObject(s, WeiBoHot.class);
        StringBuilder sb = new StringBuilder();
        for (WeiBoHot.WeiBo weiBo : weiBoHot.getData().getBand_list()) {
            sb.append(weiBo.getNote()).append("。");
        }
        return sb.toString();
    }


    public String grabBaiduHotNews2() {
        String url = "https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065";
        StringBuilder sb = new StringBuilder();
        try {
            Document doc = Jsoup.connect(url).get();
            //标题
            Elements titles = doc.select(".c-single-text-ellipsis");

            for (Element title : titles) {
                sb.append(title.text().trim()).append("。");
            }
            return sb.toString();

        } catch (IOException e) {
            logger.error("抓取百度热点排行榜异常：" + e.getMessage());
        }
        return null;
    }

    public String grabHotNews2(Integer size) {
        try {
            List<NewsModel> list1 = grabBaiduHotNews();
            List<NewsModel> list2 = grabWeiBoHotNews();
            List<NewsModel> list3 = getDouYinHotNews();
            //60%的权重是百度，40%的权重是微博
            int l1 = size * 60 / 100;
            int l2 = size - l1;
            if (list1.size() < l1) {
                l1 = list1.size();
                l2 = size - l1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l1; i++) {
                sb.append(list1.get(i).getTitle()).append("。");
            }
            if (list2.size() < l2) {
                l2 = list2.size();
            }
            for (int i = 0; i < l2; i++) {
                sb.append(list2.get(i).getTitle()).append("。");
            }
            return sb.toString();
        } catch (Exception e) {
            logger.error("抓取热点排行榜异常：", e);
        }
        return null;

    }

    public ResultObj grabHotNews3(Integer size) {
        if (size <= 0 || StringUtils.isEmpty(size)) {
            return ResultObj.error("参数错误");
        }
        try {
            Set<String> set = getHotNews(size);
            StringBuilder sb = new StringBuilder();
            for (String s : set) {
                sb.append(s).append("。");
            }
            return ResultObj.success("获取热搜成功", set.size(), sb.toString());
        } catch (Exception e) {
            logger.error("抓取热点排行榜异常：", e);
            return ResultObj.error("获取热搜失败");
        }


    }

    public Set<String> getHotNews(int size) {
        try {
            List<NewsModel> list1 = grabBaiduHotNews();
            List<NewsModel> list2 = grabWeiBoHotNews();
            List<NewsModel> list3 = getDouYinHotNews();
            //40%的权重是百度，30%的权重是微博 ,30%的权重是抖音
            int l1 = size * 40 / 100;
            int l2 = size * 30 / 100;
            int l3 = size - l1 - l2;
            Set<String> set = new HashSet<>();
            if (list1.size() < l1) {
                l1 = list1.size();
                l2 = size - l1 - l2;
            }
            if (list2.size() < l2) {
                l2 = list2.size();
                l3 = size - l1 - l2;
            }
            if (list3.size() < l3) {
                l3 = list3.size();
            }
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (j = 0; j < l1; j++) {
                set.add(list1.get(j).getTitle());
                // sb.append(list1.get(i).getTitle()).append("。");
            }
            for (int i = 0; i < l2; i++) {
                set.add(list2.get(i).getTitle());
            }
            for (int i = 0; i < l3; i++) {
                set.add(list3.get(i).getTitle());
            }
            if (set.size() < size) {
                int n = size - set.size();
                if ((list1.size() - l1) < n) {
                    n = list1.size() - l1;
                }
                for (int i = 0; i < n; i++) {
                    set.add(list1.get(++j).getTitle());
                }
            }
            return set;
        } catch (Exception e) {
            logger.error("抓取热点排行榜异常：", e);
            return null;
        }
    }

    public List<String> getHotNews4(Integer size) {
        if (size <= 0 || StringUtils.isEmpty(size)) {
            return null;
        }
        try {
            //set 转list
            return new ArrayList<>(getHotNews(size));
        } catch (Exception e) {
            logger.error("抓取热点排行榜异常：", e);
            return null;
        }
    }

    //获取抖音热搜
    public List<NewsModel> getDouYinHotNews() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("authority", "");
            //:authority: mcs.zijieapi.com
            //:method: POST
            //:path: /list
            //:scheme: https
            //accept: */*
            //accept-encoding: gzip, deflate, br
            //accept-language: zh-CN,zh;q=0.9
            //content-length: 1783

            String s = HttpUtils.get("https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/?reflow_source=reflow_page");

            List<NewsModel> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseObject(s).getJSONArray("word_list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(new NewsModel(jsonObject.getString("word")));
            }

            return list;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }


    public String getDouYinHotNews2() {
        try {
            String s = getDouYinHots();
            logger.info(s);
            StringBuilder sb = new StringBuilder();
            JSONArray jsonArray = JSON.parseObject(s).getJSONArray("word_list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                sb.append(jsonObject.getString("word")).append("。");
            }
            return sb.toString();
        } catch (Exception e) {
            logger.error("JSON解析失败", e);
            return null;
        }
    }

    public String getDouYinHotNews3() {
        try {
            String s = getDouYinHots();
            logger.info(s);
            StringBuilder sb = new StringBuilder();
            JSONArray jsonArray = JSON.parseObject(s).getJSONArray("word_list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                sb.append(jsonObject.getString("word")).append("。");
            }
            return sb.toString();
        } catch (Exception e) {
            logger.error("JSON解析失败", e);
            return null;
        }
    }

    public String getDouYinHots() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("authority", "douyin.com");
            map.put("referer", "https://www.iesdouyin.com/");
            map.put("path", "/web/api/v2/hotsearch/billboard/word/");
            map.put("scheme", "https");
            map.put("method", "GET");
            map.put("accept", "*/*");
//            map.put("accept-encoding", "gzip, deflate, br");
//            map.put("accept-language", "zh-CN,zh;q=0.9");
//            map.put("content-length", "1783");

            return HttpUtils.getRandomUserAgent("https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/?reflow_source=reflow_page", map);
        } catch (Exception e) {
            logger.error("获取抖音热搜失败", e);
            return null;
        }
    }
}