package com.king.open_api.entity;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.king.open_api.util.HttpUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class MingYan {
    private String content;
    //     "content": "只看一个人的著作，结果是不大好的：你就得不到多方面的优点。必须如蜜蜂一样，采过许多花，这才能酿出蜜来，倘若叮在一处，所得就非常有限，枯燥了。",
//             "author": "鲁迅",
//             "typeid": 27
    private String author;
    private Integer typeid;
    private String id;

    //从配置文件中获取token


    //从接口获取一个随机的名言
    //https://www.free-api.com/doc/372
    public static MingYan getRandomMingYan() {

        String url = "https://v2.alapi.cn/api/mingyan?token=" + Key.api_manager_token +
                "&format=json&typeid=" + Math.random() * 18 + 1;
        String res = HttpUtils.get(url);


        System.out.println(res);
        JSONObject jsonObject = JSON.parseObject(res);
        //"code": 200,
        if (jsonObject.getInteger("code") != 200) {
            throw new RuntimeException("免费api接口异常");
        }


        return jsonObject.getJSONObject("data").to(MingYan.class);
    }

    //疯狂星期四	https://api.shadiao.pro/kfc
    //{
    //  "data": {
    //    "type": "彩虹屁",
    //    "text": "抱住了你，我就拥有了整个世界。"
    //  }
    //}
    public static String getKfc() {
        String url = "https://api.shadiao.pro/kfc";
        String res = HttpUtils.get(url);
        JSONObject jsonObject = JSON.parseObject(res);
        String text = jsonObject.getJSONObject("data").getString("text");
        //判断语句中有没有中文
        if (text.contains("\"")) {
            return getKfc();
        }
        return jsonObject.getJSONObject("data").getString("text");
    }

    public static String getWeekTips() {
        //获取星期几1表示周日，2表示周一
        int week = DateUtil.thisDayOfWeek();

        switch (week){
            case 1:
                return "周日啦，转眼一周就过去了，有没有记录这一周都干了些什么呢？";
            case 2:
                return "周一下午好，新的一周也要有好心情！";
            case 3:
                return "今天是周二，要努力呀！";
            case 4:
                return "周三下午好，记得按时吃饭，照顾好自己鸭！";
            case 5:
                return getKfc();
            case 6:
                return "周五下午好，哪怕明天是双休日今天也要早点休息鸭！";
            case 7:
                return "今天周六啦～，记得外出走走，多锻炼🏌️‍♀";
            default:
                return "今天是周日，要开心呀！";
        }
        
    }

    public static void main(String[] args) {
        String s =
                "⣀⣆⣰⣒⣒⡀⢀⠔⠠⠤⡦⠤⠄⢴⠤⠤⠤⢴⠄\r\n⢰⣒⣒⣒⣲⠄⠠⡎⠸⠽⠽⠽⠄⠼⡭⠭⠭⡽⠄\r\n⢸⠒⠒⢒⣺⠄⠄⡇⡍⣝⣩⢫" +
                        "⠄⣊⣒⣺⣒⣊⡂\r\n⢠⠤⠴⠤⠤⠄⢐⢔⠐⠒⡖⠒⠄\r\n⣹⢸⢍⢉⢽⠄⢀⢼⠠⠤⡧⠤⠄\r\n⡜⡸⠔⠑⠜⡄⠠⡸⢀⣀⣇" +
                        "⣀⠄\r\n⢰⣒⣒⣒⣲⠄⠠⡦⢴⠄⡖⢲⠄⡖⢲⠒⢲⠒⡆\r\n⢸⣒⣲⣒⣚⠄⠄⡯⢽⠄⣏⣹⠄⡇⡸⠄⢸⣀⡇\r\n⣑⣒⣺⣒⣒⡀⢈" +
                        "⠍⠩⣡⠃⣸⠄⣏⣀⣀⣀⣀⡇\r\n⡄   ⡄⠐⢲⠒⠄⡆⠢⠄⡤⠤⠄⢀⠤⢄\r\n⢱⢰⠁⠈⢹⣉⠉⡏⡍⠄⠗⠒⡄⢸    ⢸\r\n  ⠇" +
                        "   ⠈⣹⢀⡠⠺⡰⠄⠢⠤⠃⠘.. .⠜\"\n";
        s = "你好⣀⣆⣰⣒⣒⡀";
        System.out.println(s.contains("\""));
    }
}
