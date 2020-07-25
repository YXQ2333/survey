package com.yxq.controller;

import com.yxq.entity.Admin;
import com.yxq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yxq
 * @date 2020/7/25 3:11
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/create")
    public void create() {
        Admin admin = new Admin();
        admin.setAccount("wulala");
        admin.setPassword("121212");
        adminService.create(admin);
    }
}
