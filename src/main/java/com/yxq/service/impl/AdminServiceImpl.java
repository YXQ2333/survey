package com.yxq.service.impl;

import com.yxq.entity.Admin;
import com.yxq.mapper.AdminMapper;
import com.yxq.service.AdminService;
import com.yxq.utils.BeanMapUtils;
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
        return adminMapper.create(admin);
    }

    @Override
    public int delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        return adminMapper.delete(map);
    }

    @Override
    public int update(Admin admin) {
        Map<String, Object> map = BeanMapUtils.beanToMapForUpdate(admin);
        map.put("id",admin.getId());
        return adminMapper.update(map);
    }

    @Override
    public List<Admin> query(Admin admin) {
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

}
