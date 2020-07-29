package com.yxq.controller;

import com.yxq.entity.*;
import com.yxq.service.QuestionService;
import com.yxq.service.SurveyService;
import com.yxq.utils.MapControl;
import com.yxq.utils.SessionUtils;
import com.yxq.utils.SystemInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author yxq
 * @date 2020/7/27 19:53
 */
@Controller
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;

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

    // 跳转到预览页面
    @GetMapping("/preview/{id}")
    public String preview(@PathVariable("id") Integer id, ModelMap modelMap) {
        Survey survey = surveyService.detail(id);
        Question question = new Question();
        question.setSurveyId(survey.getId());
        // 查询一个问卷中所有问题
        List<Question> questions = questionService.query(question);
        // 设置为问卷的问题
        survey.setQuestions(questions);
        modelMap.addAttribute("survey", survey);
        return "survey/preview";
    }
    // 发布问卷
    @PostMapping("/publish")
    @ResponseBody
    public Map<String,Object> publish(Integer id,HttpServletRequest request) {
        Survey test = surveyService.detail(id);
        System.out.println(test.getState());
        if (!Survey.STATE_EXEC.equals(test.getState())) {
            return MapControl.getInstance().error("当前问卷未在执行时间内，发布失败！").getMap();
        }
        String uuid = "/questionnaire/" + UUID.randomUUID().toString();
        Survey survey = new Survey();
        survey.setId(id);
        String url = "http://"+request.getServerName()+":" + request.getServerPort() + request.getContextPath() + uuid;
        survey.setUrl(url);
        surveyService.update(survey);
        return MapControl.getInstance().success("发布成功").getMap();
    }

    @GetMapping("/question")
    public String question(Integer id, ModelMap modelMap) {
        Survey survey = surveyService.detail(id);
        modelMap.addAttribute("survey", survey);
        return "survey/question";
    }

    // 用户管理
    @GetMapping("/list")
    public String list(Survey survey, ModelMap modelMap) {
        return "survey/list";
    }

    // 上传背景图
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Integer id, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 上传文件
        String filename = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String saveName = uuid + "_" + filename.substring(filename.lastIndexOf(File.separator) + 1);
        try {
            multipartFile.transferTo(new File(path, saveName));
            Survey survey = new Survey();
            survey.setId(id);
            survey.setBgimg(saveName);
            surveyService.update(survey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:preview/" + id;
    }

    // 提交问卷
    @PostMapping("/submit")
    @ResponseBody
    public Map<String,Object> submit(@RequestBody List<Map<String,Object>> list) {
        List<AnswerOpt> answerOptList = new ArrayList<>();
        List<AnswerTxt> answerTxtList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            // 如果是选择题
            if ("1".equals(object2String(map.get("type"))) || "2".equals(object2String(map.get("type")))) {
                List<Object> opts = (List<Object>) map.get("opts");
                for (Object opt : opts) {
                    AnswerOpt answerOpt = new AnswerOpt();
                    answerOpt.setQuestionId(object2Integer(map.get("questionId")));
                    answerOpt.setSurveyId(object2Integer(map.get("surveyId")));
                    answerOpt.setType(object2String(map.get("type")));
                    answerOpt.setOptId(object2Integer(opt));
                    answerOpt.setCreateTime(new Date());
                    answerOptList.add(answerOpt);
                }
            }else if ("3".equals(object2String(map.get("type"))) || "4".equals(object2String(map.get("type")))) {   // 非选择题
                AnswerTxt answerTxt = new AnswerTxt();
                answerTxt.setQuestionId(object2Integer(map.get("questionId")));
                answerTxt.setSurveyId(object2Integer(map.get("surveyId")));
                answerTxt.setResult(object2String(map.get("result")));
                answerTxt.setCreateTime(new Date());
                answerTxtList.add(answerTxt);
            }
        }
        surveyService.submit(answerOptList,answerTxtList);
        return MapControl.getInstance().success("提交成功").getMap();
    }

    public String object2String(Object object) {
        if (object != null) {
            return object+"";
        }
        return null;
    }
    public Integer object2Integer(Object object) {
        if (object != null) {
            return Integer.parseInt(object+"");
        }
        return null;
    }

}
