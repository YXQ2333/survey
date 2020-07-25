package com.yxq.entity;

import java.util.Date;
import java.util.List;

/**
 * @author yxq
 * @date 2020/7/25 3:05
 */
public class Survey {
    public static final String STATE_CREATE = "创建";
    public static final String STATE_EXEC = "执行中";
    public static final String STATE_OVER = "结束";
    private Integer id;
    private String title;
    private String remark;
    private Integer bounds;    // 0限制，1限制
    private Date startTime;
    private Date endTime;
    private Integer rules;    // 0公开，1密码
    private String password;
    private String url;
    private String state;    // 状态：创建，执行中，已结束
    private String logo;
    private String bgimg;
    private Integer anon;    // 0匿名，1不匿名
    private Integer creator;
    private Date createTime;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", remark='" + remark + '\'' +
                ", bounds=" + bounds +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", rules=" + rules +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", state='" + state + '\'' +
                ", logo='" + logo + '\'' +
                ", bgimg='" + bgimg + '\'' +
                ", anon=" + anon +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", admin=" + admin +
                ", questions=" + questions +
                '}';
    }
}