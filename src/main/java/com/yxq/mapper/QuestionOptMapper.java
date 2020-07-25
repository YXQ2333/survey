package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.QuestionOpt;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface QuestionOptMapper {
    int create(QuestionOpt questionOpt);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<QuestionOpt> query(Map<String, Object> paramMap);

    QuestionOpt detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}