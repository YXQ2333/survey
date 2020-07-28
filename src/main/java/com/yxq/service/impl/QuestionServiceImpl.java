package com.yxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.yxq.entity.Question;
import com.yxq.entity.QuestionOpt;
import com.yxq.mapper.QuestionMapper;
import com.yxq.mapper.QuestionOptMapper;
import com.yxq.service.QuestionService;
import com.yxq.utils.BeanMapUtils;
import com.yxq.utils.MapParameter;
import com.yxq.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/27 19:50
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionOptMapper  questionOptMapper;

    @Override
    public int create(Question question) {
        int count = 0;
        // 如果已存在，则更新
        if (question.getId() != null) {
            count = this.update(question);
            questionOptMapper.delete(MapParameter.getInstance().add("questionId",question.getId()).getMap());
        } else {    // 不存在则新建
            count = questionMapper.create(question);
        }
        if (count > 0) {
            List<QuestionOpt> options = question.getOptions();
            // 问题序号
            int i = 0;
            // 添加问题到tb_question_opt表
            for (QuestionOpt option : options) {
                option.setSurveyId(question.getSurveyId());
                option.setQuestionId(question.getId());
                option.setOrderby(++i);
                questionOptMapper.create(option);
            }
        }
        return question.getId();
    }

    @Override
    public int delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        return questionMapper.delete(map);
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] split = ids.split(",");
        for (String s : split) {
            // 删除问题
            Map<String,Object> map = new HashMap<>();
            map.put("id",Integer.parseInt(s));
            questionMapper.delete(map);
            // 删除选项
            questionOptMapper.delete(MapParameter.getInstance().put("questionId",Integer.parseInt(s)).getMap());
            count++;
        }
        return count;
    }

    @Override
    public int update(Question question) {
        Map<String, Object> map = BeanMapUtils.beanToMapForUpdate(question);
        map.put("id",question.getId());
        return questionMapper.update(map);
    }

    @Override
    public List<Question> query(Question question) {
        // 仅查询问题
        Map<String, Object> map = BeanMapUtils.beanToMap(question);
        // 查询
        List<Question> questionList = questionMapper.query(map);
        List<QuestionOpt> questionOptList = questionOptMapper.query(MapParameter.getInstance().put("surveyId", question.getSurveyId()).getMap());
        for (Question question1 : questionList) {
            List<QuestionOpt> options = new ArrayList<>();
            for (QuestionOpt questionOpt : questionOptList) {
                if (question1.getId() == questionOpt.getQuestionId()) {
                    options.add(questionOpt);
                }
            }
            question1.setOptions(options);
        }
        return questionList;
    }

    @Override
    public Question detail(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return questionMapper.detail(map);
    }

    @Override
    public int count(Question question) {
        Map<String, Object> map = BeanMapUtils.beanToMap(question);
        return questionMapper.count(map);
    }

}
