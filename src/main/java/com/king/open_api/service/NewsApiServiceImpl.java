package com.king.open_api.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.entity.TencentNews;
import com.king.open_api.util.HttpUtils;
import com.king.open_api.vo.NewsModel;
import com.king.open_api.vo.ResultObj;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: King
 * @project: vibrator-spider
 * @date: 2022年07月24日 03:11
 * @description:
 */
@Service
public class NewsApiServiceImpl {
    //腾讯新闻接口
    public static final String TENCENT_NEWS_API =
            "https://i.news.qq.com/trpc.qqnews_web.kv_srv.kv_srv_http_proxy/list?" +
                    "sub_srv_id=24hours&srv_id=pc&offset=0&limit=30&strategy=1&ext=" +
                    "{%22pool%22:[%22top%22],%22is_filter%22:7,%22check_type%22:true}";
    //新浪新闻接口
    public static final String SINA_NEWS_API = "https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.00ZQZQZ0qZ0qZCb8c8f8f8f8f8f8f8f&count=30";
    //网易新闻接口
    public static final String NETEASE_NEWS_API = "https://api.caijing.com.cn/api/v2/news/list?page=1&page_size=20&cid=&wm=b207&from=6042095012&chwm=12050_0001&oldchwm=12050_0001&imei=&uid=&mac=&mid=&idfa=&openudid=&title=&abtest=&udid=&wifi=1&v=2&sudaref=&lng=&lat=&city=&province=&country=&isp=&network_type=&language=&os=&os_version=&device_type=&resolution=&aid=12050&token=&_signature=0A5F8F8F7F7B1C1";
    //澎湃新闻接口
    public static final String PENPAI_NEWS_API = "https://api.caijing.com.cn/api/v2/news/list?page=1&page_size=20&cid=&wm=b207&from=6042095012&chwm=12050_0001&oldchwm=12050_0001&imei=&uid=&mac=&mid=&idfa=&openudid=&title=&abtest=&udid=&wifi=1&v=2&sudaref=&lng=&lat=&city=&province=&country=&isp=&network_type=&language=&os=&os_version=&device_type=&resolution=&aid=12050&token=&_signature=0A5F8F8F7F7B1C1";

    Logger logger = org.slf4j.LoggerFactory.getLogger(NewsApiServiceImpl.class);

    public ResultObj getNews() {
        String s = getTencentNews();
        TencentNews tencentNews = JSON.parseObject(s, TencentNews.class);
        NewsModel newsModel = tencentNews.toNewsModel();
//        logger.info("获取到的新闻内容：{}", newsModel);
        return ResultObj.success(newsModel);
    }

    //获取腾讯新闻
    public String getNetEaseNews() {
        return HttpUtil.get(NETEASE_NEWS_API);
    }

    public String getJson(Integer page) {
        return "{\"base_req\":{\"from\":\"pc\"},\"forward\":\"1\"," +
                "\"qimei36\":\"0_PPtbzP69FPBbE\"," +
                "\"device_id\":\"0_PPtbzP69FPBbE\",\"flush_num\":" + page + ",\"channel_id\":" +
                "\"news_news_top\",\"item_count\":20}";
    }

    public ResultObj getTencentNews2() {
        String urls = "https://i.news.qq.com/web_feed/getHotModuleList";


        String paramMap = HttpUtils.post(urls, getJson(1));

        JSONArray jsonArray = JSON.parseObject(paramMap).getJSONArray("data");


        List<NewsModel> newsModels = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String title = jsonObject.getString("title");

            String url = jsonObject.getJSONObject("link_info").getString("share_url");
            String id = jsonObject.getString("id");
            String content = jsonObject.getString("desc");

            String time = jsonObject.getString("publish_time");
            String img = jsonObject.getJSONObject("pic_info").getString("big_img");
            newsModels.add(new NewsModel(url, "腾讯新闻", content, title, time, img));
        }


        String paramMap1 = HttpUtils.post(urls, getJson(2));

        JSONArray jsonArray1 = JSON.parseObject(paramMap1).getJSONArray("data");

        for (int i = 0; i < 5; i++) {
            JSONObject jsonObject = jsonArray1.getJSONObject(i);
            String title = jsonObject.getString("title");
            String url = jsonObject.getJSONObject("link_info").getString("share_url");
            String id = jsonObject.getString("id");
            String content = jsonObject.getString("desc");

            String time = jsonObject.getString("publish_time");
            String img = jsonObject.getJSONObject("pic_info").
                    getJSONArray("big_img").getString(0);
            newsModels.add(new NewsModel(url, "腾讯新闻", content, title, time, img));
        }

        return ResultObj.success(newsModels.size(), newsModels);
    }

    public static void main(String[] args) {
        NewsApiServiceImpl newsApiService = new NewsApiServiceImpl();
        System.out.println(newsApiService.getNewsBySize2(20));
    }

    public String getTencentNews() {
        return HttpUtil.get(TENCENT_NEWS_API);
    }


//    public ResultObj getNewsBySize(Integer size) {
//
//
//        String url = "http://v.juhe.cn/toutiao/index?type=top&key=APPKEY";
//        return ResultObj.success(newsModels);
//    }

    //https://www.tianapi.com/apiview/87-1


    public ResultObj getNewsBySize2(Integer size) {

        //key	string	是	您自己的APIKEY（注册账号后获得）	API密钥
        //num	int	否	10	返回数量1-50，默认10
        //page	int	否	0	翻页
        //rand	int	否	0	随机获取，0->不随机、1->随机
        //word	string	否	天行数据	搜索关键词
        //source	string	否	网易明星	指定来源
        String result = "";
        try {
            URL url = new URL("https://apis.tianapi.com/generalnews/index");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoOutput(true);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            OutputStream outputStream = conn.getOutputStream();
            String content = "key=f5c05eef041e9e84f1c7d4a844daa1de&num=" + size;
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder tianapi = new StringBuilder();
            String temp = null;
            while (null != (temp = bufferedReader.readLine())) {
                tianapi.append(temp);
            }
            result = tianapi.toString();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String result = HttpUtil.get(url2, params);
        logger.info("获取到的新闻内容：{}", result);
        JSONObject jsonObject = JSON.parseObject(result);
        int code = jsonObject.getInteger("code");
        if (code != 200) {
            return ResultObj.error("获取新闻失败");
        }

        JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("newslist");
        List<NewsModel> newsModels = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            String title = jsonObject1.getString("title");
            String url = jsonObject1.getString("url");
            String content = jsonObject1.getString("description");
            String time = jsonObject1.getString("ctime");
            String img = jsonObject1.getString("picUrl");
            String source = jsonObject1.getString("source");
            newsModels.add(new NewsModel(url, source, content, title, time, img));
        }
        return ResultObj.success(newsModels.size(), newsModels);
    }
}