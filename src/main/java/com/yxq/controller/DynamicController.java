package com.yxq.controller;

import com.yxq.entity.Question;
import com.yxq.entity.Survey;
import com.yxq.service.QuestionService;
import com.yxq.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author yxq
 * @date 2020/7/29 1:08
 */
@Controller
public class DynamicController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questionnaire/{uuid}")
    public String preview(@PathVariable("uuid") String uuid, ModelMap modelMap) {
        // 找到所有执行中的问卷
        Survey exec = new Survey();
        exec.setState(Survey.STATE_EXEC);
        List<Survey> surveyList = surveyService.queryAll(exec);
        Survey entity = null;
        for (Survey survey : surveyList) {
            if (survey.getUrl().contains(uuid)) {
                entity = survey;
            }
        }
        if (entity == null) {
            modelMap.addAttribute("msg","您要访问的问卷不存在！");
            return "error";
        }
        Question question= new Question();
        question.setSurveyId(entity.getId());
        // 查询问卷中所有问题及选项
        List<Question> questionList = questionService.query(question);
        // 将问题设置为问卷属性
        entity.setQuestions(questionList);
        modelMap.addAttribute("survey",entity);
        return "survey/exec";

    }


}
