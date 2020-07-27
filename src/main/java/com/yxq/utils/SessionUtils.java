package com.yxq.utils;

import com.yxq.entity.Admin;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yxq
 * @date 2020/7/27 20:39
 */
public class SessionUtils {
    private static final String KEY = "admin";


    public static void setAdmin(HttpServletRequest request, Admin admin) {
        request.getSession().setAttribute(KEY, admin);
    }

    public static Admin getAdmin(HttpServletRequest request) {
        return (Admin) request.getSession().getAttribute(KEY);
    }
}
