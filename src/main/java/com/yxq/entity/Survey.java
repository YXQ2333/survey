package com.yxq.entity;

import java.util.Date;
import java.util.List;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class Survey {
    public static final String state_create = "创建";
    public static final String state_exec = "执行中";
    public static final String state_over = "结束";
    private Integer anon;    // 0匿名，1不匿名
    private String bgimg;
    private Integer bounds;    // 0限制，1限制
    private Date createTime;
    private Integer creator;
    private Date endTime;
    private Integer id;
    private String logo;
    private String password;
    private String remark;
    private Integer rules;    // 0公开，1密码
    private Date startTime;
    private String state;    // 状态：创建，执行中，已结束
    private String title;
    private String url;
    private Admin admin;    // 创建者信息


    private List<Question> questions;


    public Integer getAnon() {
        return anon;
    }

    public void setAnon(Integer anon) {
        this.anon = anon;
    }

    public String getBgimg() {
        return bgimg;
    }

    public void setBgimg(String bgimg) {
        this.bgimg = bgimg;
    }

    public Integer getBounds() {
        return bounds;
    }

    public void setBounds(Integer bounds) {
        this.bounds = bounds;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRules() {
        return rules;
    }

    public void setRules(Integer rules) {
        this.rules = rules;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "anon=" + anon +
                ", bgimg='" + bgimg + '\'' +
                ", bounds=" + bounds +
                ", createTime=" + createTime +
                ", creator=" + creator +
                ", endTime=" + endTime +
                ", id=" + id +
                ", logo='" + logo + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", rules=" + rules +
                ", startTime=" + startTime +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", admin=" + admin +
                ", questions=" + questions +
                '}';
    }
}