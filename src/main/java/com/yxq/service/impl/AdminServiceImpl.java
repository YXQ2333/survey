package com.yxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.yxq.entity.Admin;
import com.yxq.mapper.AdminMapper;
import com.yxq.service.AdminService;
import com.yxq.utils.BeanMapUtils;
import com.yxq.utils.Entity;
import com.yxq.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/25 3:08
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int create(Admin admin) {
        // 加密
        admin.setPassword(Md5Utils.getMd5(admin.getPassword()));
        return adminMapper.create(admin);
    }

    @Override
    public int delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        return adminMapper.delete(map);
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] split = ids.split(",");
        for (String s : split) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",Integer.parseInt(s));
            adminMapper.delete(map);
            count++;
        }
        return count;
    }

    @Override
    public int update(Admin admin) {
        Map<String, Object> map = BeanMapUtils.beanToMapForUpdate(admin);
        map.put("id",admin.getId());
        return adminMapper.update(map);
    }

    @Override
    public List<Admin> query(Admin admin) {
        PageHelper.startPage(admin.getPage(),admin.getLimit());
        Map<String, Object> map = BeanMapUtils.beanToMap(admin);
        return adminMapper.query(map);
    }

    @Override
    public Admin detail(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return adminMapper.detail(map);
    }

    @Override
    public int count(Admin admin) {
        Map<String, Object> map = BeanMapUtils.beanToMap(admin);
        return adminMapper.count(map);
    }

    @Override
    public Admin login(String account, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("account",account);
        map.put("password",password);
        return adminMapper.detail(map);
    }

}
