package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.AnswerTxt;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AnswerTxtMapper {
    int create(AnswerTxt answerTxt);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<AnswerTxt> query(Map<String, Object> paramMap);

    AnswerTxt detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}