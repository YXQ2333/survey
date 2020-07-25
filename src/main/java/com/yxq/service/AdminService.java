package com.yxq.service;

import com.yxq.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/25 3:08
 */
public interface AdminService {
    int create(Admin admin);

    // 根据用户删除
    int delete(Integer id);

    int update(Admin admin);

    List<Admin> query(Admin admin);

    Admin detail(Integer id);

    int count(Admin admin);

}
