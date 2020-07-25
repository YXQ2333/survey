package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.QuestionOpt;
/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface QuestionOptMapper {
	public int create(QuestionOpt pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<QuestionOpt> query(Map<String, Object> paramMap);
	public QuestionOpt detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}