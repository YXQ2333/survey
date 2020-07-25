package com.yxq.entity;

import java.util.Date;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class AnswerOpt {
    private Integer id;
    private Integer surveyId;
    private Integer questionId;
    private Integer optId;
    private String type;    // 1是单选，2是多选
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

    public Integer getOptId() {
        return optId;
    }

    public void setOptId(Integer optId) {
        this.optId = optId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    @Override
    public String toString() {
        return "AnswerOpt{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", questionId=" + questionId +
                ", optId=" + optId +
                ", type='" + type + '\'' +
                ", createTime=" + createTime +
                ", voter='" + voter + '\'' +
                '}';
    }
}