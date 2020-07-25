package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Survey;

/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface SurveyMapper {
    int create(Survey survey);

    int delete(Map<String, Object> paramMap);

    int update(Map<String, Object> paramMap);

    List<Survey> query(Map<String, Object> paramMap);

    Survey detail(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);

    List<Integer> queryByState(String state);

    List<Integer> queryByStateForExec(String state);
}