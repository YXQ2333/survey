package com.yxq.controller;

import com.yxq.entity.Question;
import com.yxq.service.QuestionService;
import com.yxq.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/28 12:30
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Question question) {
        Integer count = questionService.create(question);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().add("id",count).getMap();
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        Integer count = questionService.deleteBatch(ids);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Question question) {
        Integer count = questionService.update(question);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Question question, ModelMap modelMap) {
        List<Question> list = questionService.query(question);
        Integer count = questionService.count(question);
        return MapControl.getInstance().page(list, count).getMap();
    }

    @GetMapping("/detail")
    public String detail(Integer id, ModelMap modelMap) {
        Question question = questionService.detail(id);
        modelMap.addAttribute("question", question);
        return "question/update";
    }

    @GetMapping("/question")
    public String question(Integer id, ModelMap modelMap) {
        Question question = questionService.detail(id);
        modelMap.addAttribute("question", question);
        return "question/question";
    }

    // 用户管理
    @GetMapping("/list")
    public String list(Question question, ModelMap modelMap) {
        return "question/list";
    }
}
