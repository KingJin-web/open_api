package com.king.open_api.service;

import com.king.open_api.util.HttpUtils;
import org.springframework.stereotype.Service;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月23日 19:56
 * @description:
 */
@Service
public class CrawlerServiceImpl {
    public String url = "https://www.pdflibr.com/crawler/parse?user_agent=%s&ip=%s";

    public String getString(String userAgent, String ip) {
        return HttpUtils.get(String.format(url, userAgent, ip));
    }
}