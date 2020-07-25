package com.yxq.entity;

/**
 * @author yxq
 * @date 2020/7/25 2:59
 */
public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private String phone;
    private String remark;

    public Admin() {
    }

    public Admin(Integer id, String account, String password, String name, String phone, String remark) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
