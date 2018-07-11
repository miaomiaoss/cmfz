package com.baizhi.zy.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;
    private String photo;
    private String username;
    private String password;
    private String salt;
    private String dharmaname;
    private String name;
    private String sex;
    private String province;
    private String city;
    private String sign;
    private String status;
    private Date createtime;
    private String state = "closed";

    public User() {
    }

    public User(String id, String photo, String username, String password, String salt, String dharmaname, String name, String sex, String province, String city, String sign, String status, Date createtime, String state) {
        this.id = id;
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.dharmaname = dharmaname;
        this.name = name;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.status = status;
        this.createtime = createtime;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharmaname() {
        return dharmaname;
    }

    public void setDharmaname(String dharmaname) {
        this.dharmaname = dharmaname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", photo='" + photo + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharmaname='" + dharmaname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                ", state='" + state + '\'' +
                '}';
    }
}
