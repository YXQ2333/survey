package com.yxq.controller;

import com.google.common.base.Strings;
import com.yxq.entity.Admin;
import com.yxq.service.AdminService;
import com.yxq.utils.MapControl;
import com.yxq.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/26 0:26
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    // 首页
    @GetMapping("/login")
    public String v_login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        String account = (String) map.get("account");
        String password = (String) map.get("password");
        Map<String,Object> result = new HashMap<>();
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(password)) {
            return MapControl.getInstance().error("账号和密码不能为空").getMap();
        }
        Admin admin = adminService.login(account, Md5Utils.getMd5(password));
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            return MapControl.getInstance().success("登录成功").getMap();
        }
        return MapControl.getInstance().error("账号或者密码错误").getMap();
    }

}
