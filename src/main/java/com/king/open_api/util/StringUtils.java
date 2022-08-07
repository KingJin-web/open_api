package com.king.open_api.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.ObjectUtils;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月06日 14:44
 * @description:
 */
public class StringUtils extends ObjectUtils {
    public static String getString(Object obj) {
        if (ObjectUtils.isEmpty(obj)) {
            return "";
        }
        return obj.toString();
    }

    public static String getString(Object obj, String defaultValue) {
        if (ObjectUtils.isEmpty(obj)) {
            return defaultValue;
        }
        return obj.toString();
    }

    public static String getString(String str) {
        if (StrUtil.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getString(String str, String defaultValue) {
        if (StrUtil.isEmpty(str)) {
            return defaultValue;
        }
        return str;
    }
}