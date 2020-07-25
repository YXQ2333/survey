package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.Survey;
/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface SurveyMapper {
	public int create(Survey pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<Survey> query(Map<String, Object> paramMap);
	public Survey detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
	public List<Integer> queryByState(String state);
	public List<Integer> queryByStateForExec(String state);
}