package com.baizhi.zy.Dto;

import com.baizhi.zy.entity.Album;
import com.baizhi.zy.entity.Banner;

import java.io.Serializable;
import java.util.List;

public class Dto implements Serializable {
    private Integer total;
    private List<?> rows;

    public Dto() {
    }

    public Dto(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
