package com.yxq.utils;

import com.yxq.entity.Admin;
import com.yxq.mapper.AdminMapper;
import com.yxq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/28 1:01
 */
public class SystemInit {
    @Autowired
    private AdminMapper adminMapper;

    public static Map<Integer,Admin> adminMap = new HashMap<>();

    public void init() {
        List<Admin> list = adminMapper.query(null);
        for (Admin admin : list) {
            adminMap.put(admin.getId(),admin);
        }
//        System.out.println("初始化加载" + adminMap);
    }
}
