package com.yxq.controller;

import com.yxq.entity.Admin;
import com.yxq.service.AdminService;
import com.yxq.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object> create(@RequestBody Admin admin) {
        int count = adminService.create(admin);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    // 跳转到添加用户页面
    @GetMapping("/create")
    public String v_create() {
        return "admin/add";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(String ids) {
        int count = adminService.deleteBatch(ids);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String,Object> update(@RequestBody Admin admin) {
        int count = adminService.update(admin);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Admin admin, ModelMap modelMap) {
        List<Admin> list = adminService.query(admin);
        int count = adminService.count(admin);
//        modelMap.addAttribute("list",list);
        return MapControl.getInstance().page(list, count).getMap();
    }

    @GetMapping("/detail")
    public String detail(Integer id,ModelMap modelMap) {
        Admin admin = adminService.detail(id);
        modelMap.addAttribute("admin",admin);
        return "admin/update";
    }

    // 用户管理
    @GetMapping("/list")
    public String list(Admin admin, ModelMap modelMap) {
        return "admin/list";
    }
}
