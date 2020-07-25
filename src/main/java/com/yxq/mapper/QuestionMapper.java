package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Question;
/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface QuestionMapper {
	public int create(Question pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<Question> query(Map<String, Object> paramMap);
	public Question detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}