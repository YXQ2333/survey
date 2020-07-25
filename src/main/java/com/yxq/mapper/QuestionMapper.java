package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Question;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface QuestionMapper {
    int create(Question question);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<Question> query(Map<String, Object> paramMap);

    Question detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}