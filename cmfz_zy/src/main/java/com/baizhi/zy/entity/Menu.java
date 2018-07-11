package com.baizhi.zy.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

    private String id;
    private String title;
    private String href;
    private String iconcls;
    private List<Menu> childrenMen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public List<Menu> getChildrenMen() {
        return childrenMen;
    }

    public void setChildrenMen(List<Menu> childrenMen) {
        this.childrenMen = childrenMen;
    }

    public Menu(String id, String title, String href, String iconcls, List<Menu> childrenMen) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.iconcls = iconcls;
        this.childrenMen = childrenMen;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", childrenMen=" + childrenMen +
                '}';
    }
}
