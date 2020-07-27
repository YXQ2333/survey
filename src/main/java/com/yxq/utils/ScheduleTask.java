package com.yxq.utils;

import com.yxq.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 计时，修改问卷状态
 *
 * @author yxq
 * @date 2020/7/28 1:37
 */
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private SurveyService surveyService;

    // 问卷状态改变
//    @Scheduled(fixedRate = 5000)
    // 秒 分 时 每月第几天 月 周 年
    @Scheduled(cron = "* */1 * * * ?")      // 每隔一分钟进行
    public void state() {
        System.out.println("执行一次");
        surveyService.updateState();
    }
}
