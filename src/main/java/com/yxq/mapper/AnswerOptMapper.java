package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.AnswerOpt;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AnswerOptMapper {
    public int create(AnswerOpt pi);

    public int delete(Map<String, Object> paramMap);

    public int update(Map<String, Object> paramMap);

    public List<AnswerOpt> query(Map<String, Object> paramMap);

    public AnswerOpt detail(Map<String, Object> paramMap);

    public int count(Map<String, Object> paramMap);
}