package com.yxq.entity;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class QuestionOpt {
    private Integer id;
    private Integer surveyId;
    private Integer questionId;
    private Integer type;    // 1单选，2多选
    private String opt;
    private Integer orderby;
    private Integer answer;    // 默认为null，1为答案
    private Integer num;    // 被选择的次数

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "QuestionOpt{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", questionId=" + questionId +
                ", type=" + type +
                ", opt='" + opt + '\'' +
                ", orderby=" + orderby +
                ", answer=" + answer +
                ", num=" + num +
                '}';
    }
}