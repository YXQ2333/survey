package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Admin;
/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AdminMapper {

    public int create(Admin pi);

    public int delete(Map<String, Object> paramMap);

    public int update(Map<String, Object> paramMap);

    public List<Admin> query(Map<String, Object> paramMap);

    public Admin detail(Map<String, Object> paramMap);

    public int count(Map<String, Object> paramMap);

}