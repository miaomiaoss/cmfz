package com.baizhi.zy.service;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface BannerService {

    //查所有轮播图
    Dto queryBanner(Integer page, Integer rows);
    //添加
    void addBanner(MultipartFile pictureFile, HttpSession session, Banner banner);
    //删除
    void deleteBanner(String id,String picPath,String realPath);
    //修改
    void changeBanner(Banner banner);
    //查一个
    Banner getOneBanner(String id);
}
