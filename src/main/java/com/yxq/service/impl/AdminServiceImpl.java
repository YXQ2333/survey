package com.yxq.service.impl;

import com.yxq.entity.Admin;
import com.yxq.mapper.AdminMapper;
import com.yxq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
