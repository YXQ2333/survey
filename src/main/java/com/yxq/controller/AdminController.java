package com.yxq.controller;

import com.yxq.entity.Admin;
import com.yxq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author yxq
 * @date 2020/7/25 3:11
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    @ResponseBody
    public String create(Admin admin) {
        int count = adminService.create(admin);
        if (count < 1) {
            return "error";
        }
        return "success";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        int count = adminService.delete(id);
        if (count < 1) {
            return "error";
        }
        return "success";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Admin admin) {
        int count = adminService.update(admin);
        if (count < 1) {
            return "错误";
        }
        return "正确";
    }

    /*@PostMapping("/query")
    @ResponseBody
    public List<Admin> query(Admin admin) {
        for (Admin admin1 : adminService.query(admin)) {
            System.out.println(admin1);
        }
        return adminService.query(admin);
    }*/
    @GetMapping("/query2")
    @ResponseBody
    public List<Admin> query(Admin admin) {
        return adminService.query(admin);
    }
    @GetMapping("/query")
    public String query(Admin admin, ModelMap modelMap) {
        List<Admin> list = adminService.query(admin);
        modelMap.addAttribute("list",list);
        return "../list.jsp";
    }

    @PostMapping("/detail")
    @ResponseBody
    public Admin detail(Integer id) {
        Admin detail = adminService.detail(id);
        detail.setNow(new Date());
//        System.out.println(adminService.detail(id));
        return detail;
//        return adminService.detail(id);
    }
}
