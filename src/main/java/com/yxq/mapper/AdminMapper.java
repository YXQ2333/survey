package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Admin;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AdminMapper {

    int create(Admin admin);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<Admin> query(Map<String, Object> paramMap);

    Admin detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);

}