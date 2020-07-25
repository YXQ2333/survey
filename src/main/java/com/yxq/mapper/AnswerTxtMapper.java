package com.yxq.mapper;

import java.util.List;
import java.util.Map;

import com.yxq.entity.AnswerTxt;
/**
 * @author yxq
 * @date 2020/7/25 3:25
 */
public interface AnswerTxtMapper {
	public int create(AnswerTxt pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<AnswerTxt> query(Map<String, Object> paramMap);
	public AnswerTxt detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}