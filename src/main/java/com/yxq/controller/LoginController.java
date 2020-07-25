package com.yxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yxq
 * @date 2020/7/26 0:26
 */
@Controller
public class LoginController {
    // 首页
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
