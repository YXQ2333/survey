package com.yxq.service;

import com.yxq.entity.Survey;

import java.util.List;

/**
 * @author yxq
 * @date 2020/7/27 19:49
 */
public interface SurveyService {
    int create(Survey survey);

    // 根据用户删除
    int delete(Integer id);

    // 批量删除
    int deleteBatch(String ids);

    int update(Survey survey);

    List<Survey> query(Survey survey);

    Survey detail(Integer id);

    int count(Survey survey);

    void updateState();
}
