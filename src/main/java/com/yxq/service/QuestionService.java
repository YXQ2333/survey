package com.yxq.service;

import com.yxq.entity.Question;

import java.util.List;

/**
 * @author yxq
 * @date 2020/7/28  12:31
 */
public interface QuestionService {
    int create(Question question);

    // 根据用户删除
    int delete(Integer id);

    // 批量删除
    int deleteBatch(String ids);

    int update(Question question);

    List<Question> query(Question question);

    Question detail(Integer id);

    int count(Question question);
}
