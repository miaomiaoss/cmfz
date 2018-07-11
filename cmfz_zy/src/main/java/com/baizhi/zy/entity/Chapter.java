package com.baizhi.zy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {

    private String id;
    private String name;
    private String size;
    private String albumId;
    private String path;
    private String length;
    private String times;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    public Chapter() {
    }

    public Chapter(String id, String name, String size, String albumId, String path, String length, String times, Date createtime) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.albumId = albumId;
        this.path = path;
        this.length = length;
        this.times = times;
        this.createtime = createtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", albumId='" + albumId + '\'' +
                ", path='" + path + '\'' +
                ", length='" + length + '\'' +
                ", times='" + times + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
