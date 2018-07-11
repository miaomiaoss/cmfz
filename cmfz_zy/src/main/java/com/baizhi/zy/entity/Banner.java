package com.baizhi.zy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Banner implements Serializable {
    private String id;
    private String picname;
    private String picpath;
    private String description;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date createtime;
    private String url;

    public Banner() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Banner(String id, String picname, String picpath, String description, String status, Date createtime, String url) {

        this.id = id;
        this.picname = picname;
        this.picpath = picpath;
        this.description = description;
        this.status = status;
        this.createtime = createtime;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", picname='" + picname + '\'' +
                ", picpath='" + picpath + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                ", url='" + url + '\'' +
                '}';
    }
}
