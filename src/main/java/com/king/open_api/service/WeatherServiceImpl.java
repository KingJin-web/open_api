package com.king.open_api.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.king.open_api.entity.MoJiWeather;
import com.king.open_api.util.StringUtils;
import com.king.open_api.vo.ResultObj;
import com.king.open_api.vo.WeatherVo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: King
 * @project: springboot
 * @date: 2022年07月27日 06:45
 * @description:
 */
@Service
public class WeatherServiceImpl {

    //讯飞语音识别内置的墨迹天气API
    private static final String WEATHER_URL_MOJI = "http://autodev.openspeech.cn/csp/api/v2.1/weather?openId=aiuicus&clientType=android&sign=android&city=%s&latitude=39.902895&longitude=116.427915&needMoreData=true&pageNo=1&pageSize=7";

    //中华万年历的天气API
    private static final String WEATHER_URL_WANNIU = "http://wthrcdn.etouch.cn/WeatherApi?city=%s";

    Logger logger = org.slf4j.LoggerFactory.getLogger(WeatherServiceImpl.class);

    //从墨迹天气API获取天气信息
    public MoJiWeather getWeatherFromMoJi(String city) {
        try {
            logger.info("城市：" + city);
            String url = String.format(WEATHER_URL_MOJI, city);
            String result = HttpUtil.get(url);
            //预警信息
            String s = StrUtil.toStringOrNull(JSON.parseObject(result).get("data.list[0].moreData"));
            System.out.println(s);
            return JSON.parseObject(result, MoJiWeather.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据城市名称获取天气信息
     *
     * @param city
     * @return
     */
    public ResultObj getWeather(String city) {
        if (StringUtils.isEmpty(city)) {
            return ResultObj.error("城市名称不能为空");
        }
        WeatherVo weatherVo = WeatherVo.convert(getWeatherFromMoJi(city));
        return ResultObj.success("success", weatherVo);
    }

    public ResultObj getWeatherByAddress(String city) {
        if (StringUtils.isEmpty(city)) {
            return ResultObj.error("城市名称不能为空");
        }
        String model = "%s%s今天：温度(%s℃ - %s℃),天气：(%s),平均温度：(%s)." +
                "风力：(%s),PM2.5：(%s),PM10：(%s)\n" +
                "明天：温度(%s℃ - %s℃),天气：(%s),风力：(%s)";
        WeatherVo weatherVo = WeatherVo.convert(getWeatherFromMoJi(city));
        List<MoJiWeather.Weather> list = weatherVo.getList();
        MoJiWeather.Weather weather = list.get(0);
        MoJiWeather.Weather weather2 = list.get(1);
        model = String.format(model,
                weather.getProvince(),weather.getCity(),weather.getLow(),weather.getHigh(),weather.getWeather(),weather.getTemp()
        ,weather.getWind(),weather.getPm25(),weather.getPm10()
        ,weather2.getLow(),weather2.getHigh(),weather2.getWeather(),weather2.getWind());
        return ResultObj.success("success", model);
    }

    public ResultObj getWeatherByIp(String city) {
        if (StringUtils.isEmpty(city)) {
            return ResultObj.error("城市名称不能为空");
        }
        String model = "%s%s今天：温度(%s℃ - %s℃),天气：(%s),平均温度：(%s)." +
                "风力：(%s),PM2.5：(%s),PM10：(%s)\n" +
                "明天：温度(%s℃ - %s℃),天气：(%s),风力：(%s)";
        WeatherVo weatherVo = WeatherVo.convert(getWeatherFromMoJi(city));
        List<MoJiWeather.Weather> list = weatherVo.getList();
        MoJiWeather.Weather weather = list.get(0);
        MoJiWeather.Weather weather2 = list.get(1);
        model = String.format(model,
                weather.getProvince(),weather.getCity(),weather.getLow(),weather.getHigh(),weather.getWeather(),weather.getTemp()
                ,weather.getWind(),weather.getPm25(),weather.getPm10()
                ,weather2.getLow(),weather2.getHigh(),weather2.getWeather(),weather2.getWind());
        return ResultObj.success("success", model);
    }
    /**
     * 根据城市名称获取当天天气信息
     *
     * @param city
     * @return
     */
    public ResultObj getTodayWeather(String city) {
        WeatherVo weatherVo = WeatherVo.convertToDay(getWeatherFromMoJi(city));
        return ResultObj.success("success", weatherVo);
    }


    public static void main(String[] args) {
        WeatherServiceImpl weatherService = new WeatherServiceImpl();
        MoJiWeather moJiWeather = weatherService.getWeatherFromMoJi("北京");
        System.out.println(moJiWeather);
    }
}
