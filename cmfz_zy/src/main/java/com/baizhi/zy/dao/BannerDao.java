package com.baizhi.zy.dao;

import com.baizhi.zy.entity.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao {

    //查所有轮播图
    List<Banner> queryBanner(@Param("page") Integer page,@Param("rows") Integer rows);
    //查总数
    Integer countBanner();
    //添加
    void addBanner(Banner banner);
    //删除
    void deleteBanner(String id);
    //修改
    void changeBanner(Banner banner);
    //查一个
    Banner getOneBanner(String id);
}
