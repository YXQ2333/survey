package com.yxq.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密相关功能
 *
 * @author yxq
 * @date 2020/7/26 2:44
 */
public class Md5Utils {
    // 盐
    private static final String SALT = "survey!#$56%^89&*()_+1234@70-=";

    public static String getMd5(String source) {
        String val = source + "/" + SALT;
        // 加密
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getMd5("123456"));
    }
}
