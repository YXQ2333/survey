package com.yxq.entity;

import java.util.Date;
import java.util.List;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class Question {
    private String checkStyle;
    private Date createTime;
    private Integer creator;
    private Integer id;
    private Integer orderStyle;    // 0顺序排列，1随机排列
    private Integer orderby;
    private String remark;
    private Integer required;    // 0非必填，1必填
    private Integer score;
    private Integer showStyle;    // 列数：1，2，3，4
    private Integer surveyId;
    private Integer test;    // 0不评测，1评测
    private String title;
    private Integer type;    // 1单选，2多选，3单行文本，4多行文本
    private List<QuestionOpt> options;


    public String getCheckStyle() {
        return checkStyle;
    }

    public void setCheckStyle(String checkStyle) {
        this.checkStyle = checkStyle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderStyle() {
        return orderStyle;
    }

    public void setOrderStyle(Integer orderStyle) {
        this.orderStyle = orderStyle;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(Integer showStyle) {
        this.showStyle = showStyle;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<QuestionOpt> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOpt> options) {
        this.options = options;
    }
}