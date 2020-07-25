package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.AnswerOpt;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AnswerOptMapper {
    int create(AnswerOpt answerOpt);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<AnswerOpt> query(Map<String, Object> paramMap);

    AnswerOpt detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}