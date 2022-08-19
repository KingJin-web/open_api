package com.king.open_api.util;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月19日 23:12
 * @description:
 */
@Slf4j
public class RandomUtils {


    static char[] lowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] upperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] other = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', ',', '.'};

    /**
     * @param length      长度 必须大于0 如果小于等于0 则默认为10 随机字符串长度
     * @param isUpperCase 是否有大写字母(A-Z)
     * @param isLowerCase 是否有小写字母(a-z)
     * @param isNumber    是否有数字(0-9)
     * @param isOther     是否有其他符号(~!@#$%^&*()-+_=,.)
     * @return
     */
    public static String getRandomString(Integer length, Boolean isUpperCase, Boolean isLowerCase, Boolean isNumber, Boolean isOther) {
        if (length == null) {
            length = 10;
        }
        if (length < 1) {
            length = 10;
        }
        if (length > 1000) {
            length = 1000;
        }
        if (isUpperCase == null) {
            isUpperCase = true;
        }
        if (isLowerCase == null) {
            isLowerCase = true;
        }
        if (isNumber == null) {
            isNumber = true;
        }
        if (isOther == null) {
            isOther = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num =RandomUtil.randomInt(0,4);
            switch (num) {
                case 0:
                    if (isUpperCase) {
                        sb.append(upperCase[RandomUtil.randomInt(0, upperCase.length)]);
                    }
                    break;
                case 1:
                    if (isLowerCase) {
                        sb.append(lowerCase[RandomUtil.randomInt(0, lowerCase.length)]);
                    }
                    break;
                case 2:
                    if (isNumber) {
                        sb.append((number[RandomUtil.randomInt(0, number.length)]));
                    }
                    break;
                case 3:
                    if (isOther) {
                        sb.append((other[RandomUtil.randomInt(0, other.length)]));
                    }
                    break;
            }
        }
        log.info("生成的随机字符串为：{}", sb.toString());
        return sb.toString();
    }
}