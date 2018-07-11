package com.baizhi.zy.entity;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {

    private String id;
    private String name;
    private String brodecast;
    private String author;
    private String count;
    private String coverpicture;
    private String score;
    private String content;
    private String createtime;
    private String status;
    private String state = "closed";
    private List<Chapter> children;

    public Album(String id, String name, String brodecast, String author, String count, String coverpicture, String score, String content, String createtime, String status, String state, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.brodecast = brodecast;
        this.author = author;
        this.count = count;
        this.coverpicture = coverpicture;
        this.score = score;
        this.content = content;
        this.createtime = createtime;
        this.status = status;
        this.state = state;
        this.children = children;
    }

    public Album() {
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

    public String getBrodecast() {
        return brodecast;
    }

    public void setBrodecast(String brodecast) {
        this.brodecast = brodecast;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCoverpicture() {
        return coverpicture;
    }

    public void setCoverpicture(String coverpicture) {
        this.coverpicture = coverpicture;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brodecast='" + brodecast + '\'' +
                ", author='" + author + '\'' +
                ", count='" + count + '\'' +
                ", coverpicture='" + coverpicture + '\'' +
                ", score='" + score + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
