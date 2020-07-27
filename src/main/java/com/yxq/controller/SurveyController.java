package com.yxq.controller;

import com.yxq.entity.Admin;
import com.yxq.entity.Survey;
import com.yxq.service.SurveyService;
import com.yxq.utils.MapControl;
import com.yxq.utils.SessionUtils;
import com.yxq.utils.SystemInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/27 19:53
 */
@Controller
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Survey survey, HttpServletRequest request) {
        // 获取创建者信息
        Admin currAdmin = SessionUtils.getAdmin(request);
        survey.setCreator(currAdmin.getId());
        survey.setState(Survey.STATE_CREATE);
        survey.setAnon(survey.getAnon() != null ? 0 : 1);
        Integer count = surveyService.create(survey);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    // 跳转到添加用户页面
    @GetMapping("/create")
    public String v_create() {
        return "survey/add";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        Integer count = surveyService.deleteBatch(ids);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Survey survey) {
        survey.setAnon(survey.getAnon() != null ? 0 : 1);
        Integer count = surveyService.update(survey);
        if (count < 1) {
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Survey survey, ModelMap modelMap) {
        List<Survey> list = surveyService.query(survey);
        // 将创建者信息写入Survey对象
        for (Survey entity : list) {
            entity.setAdmin(SystemInit.adminMap.get(entity.getCreator()));

        }
        Integer count = surveyService.count(survey);
        return MapControl.getInstance().page(list, count).getMap();
    }

    @GetMapping("/detail")
    public String detail(Integer id, ModelMap modelMap) {
        Survey survey = surveyService.detail(id);
        modelMap.addAttribute("survey", survey);
        return "survey/update";
    }

    // 用户管理
    @GetMapping("/list")
    public String list(Survey survey, ModelMap modelMap) {
        return "survey/list";
    }
}
