package com.yxq.entity;

import java.util.Date;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class AnswerTxt {
    private Integer id;
    private Integer surveyId;
    private Integer questionId;
    private String result;
    private Date createTime;
    private String voter;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    @Override
    public String toString() {
        return "AnswerTxt{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", questionId=" + questionId +
                ", result='" + result + '\'' +
                ", createTime=" + createTime +
                ", voter='" + voter + '\'' +
                '}';
    }
}