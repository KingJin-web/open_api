package com.king.open_api.util;

import cn.hutool.core.util.RandomUtil;
import com.king.open_api.vo.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.util.ObjectUtils;

/**
 * @author: King
 * @project: open_api
 * @date: 2022年08月19日 23:12
 * @description:
 */

public class RandomUtils {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(RandomUtils.class);
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
    public static ResultObj getRandomString(Integer length, Boolean isUpperCase,
                                            Boolean isLowerCase, Boolean isNumber, Boolean isOther) {
        try {
            if (ObjectUtils.isEmpty(length) || length <= 0) {
                length = 10;
            }

            if (length > 10000) {
                return ResultObj.error("随机字符串长度不能大于10000");
            }
            // 初始化--- 如果为空则默认为true
            isUpperCase = getDefaultValue(isUpperCase);
            isLowerCase = getDefaultValue(isLowerCase);
            isNumber = getDefaultValue(isNumber);
            isOther = getDefaultValue(isOther);
            //如果全是false 返回错误
            if (check(isUpperCase) && check(isLowerCase) && check(isNumber) && check(isOther)) {
                return ResultObj.error("参数不能全是false");
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int num = RandomUtil.randomInt(0, 4);
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
            logger.debug("生成的随机字符串为：{}", sb);

            return ResultObj.success(sb.toString());
        } catch (Exception e) {
            logger.error("生成随机字符串出错：", e);
            return ResultObj.error("生成随机字符串失败");
        }
    }

    //md5加密
    public static String getMD5(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //随机生成人名
    public static String getRandomName() {
        String[] firstName = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"};
        String[] lastName = {"子璇", "淼", "国栋", "夫子", "瑞堂", "甜", "敏", "尚", "国贤", "贺祥", "晨涛", "昊轩", "易轩", "益辰", "益帆", "益冉", "瑾春", "瑾昆", "春齐", "杨", "文昊", "东东", "雄霖", "浩晨", "熙涵", "溶溶", "冰枫", "欣欣", "宜豪", "欣慧", "建政", "美欣", "淑慧", "文轩", "文杰", "欣源", "忠林", "榕润", "欣汝", "慧嘉", "新建", "建林", "亦菲", "林", "冰洁", "佳欣", "涵涵", "禹辰", "淳美", "泽惠", "伟洋", "涵越", "润丽", "翔", "淑华", "晶莹", "凌晶", "苒溪", "雨涵", "嘉怡", "佳毅", "子辰", "佳琪", "紫轩", "瑞辰", "昕蕊", "萌", "明远", "欣宜", "泽远", "欣怡", "佳怡", "佳惠", "晨茜", "晨璐", "运昊", "汝鑫", "淑君", "晶滢", "润莎", "榕汕", "佳钰", "佳玉", "晓庆", "一鸣", "语晨", "添池", "添昊", "雨泽", "雅晗", "雅涵", "清妍", "诗悦", "嘉乐", "晨涵", "天赫", "玥傲", "佳昊", "天昊", "萌萌", "若萌", "若枫", "若灵", "若彤", "若林", "若琳", "若柳", "若娜", "若妮", "若影", "若晴", "若文", "若晓", "若枫", "若萱", "若霜", "若山", "若翔", "若竹", "若月", "若曼", "若林", "若萌", "若柏", "若博", "若拔", "若柏", "若林", "若柳", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔", "若林", "若柏", "若博", "若拔"};
        String randomName = firstName[(int) (Math.random() * firstName.length)] + lastName[(int) (Math.random() * lastName.length)];
        logger.info("randomName:{}", randomName);
        return randomName;
    }

    //参数校验
    public static boolean check(boolean b) {
        return (!ObjectUtils.isEmpty(b) && !b);
    }

    //默认值
    public static Boolean getDefaultValue(Boolean value, Boolean defaultValue) {
        return ObjectUtils.isEmpty(value) ? defaultValue : value;
    }

    //默认值
    public static Boolean getDefaultValue(Boolean value) {
        return ObjectUtils.isEmpty(value) || value;
    }


}