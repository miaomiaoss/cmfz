package com.baizhi.zy.controller;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.entity.Banner;
import com.baizhi.zy.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class BannerController {

    @Resource(name = "bannerService")
    private BannerService service;

    //查所有
    @RequestMapping(value = "/queryBanner", produces = "text/plain;charset=UTF-8")
    public Dto queryBanner(Integer page, Integer rows){
        return service.queryBanner(page,rows);
    }

    //添加
    @RequestMapping("/addBanner")
    public void addBanner(HttpSession session, MultipartFile pictureFile, Banner banner){

        service.addBanner(pictureFile, session, banner);
    }

    //删除
    @RequestMapping("/deleteBanner")
    public void deleteBanner(String id,String picPath,HttpSession session){
        String realPath = session.getServletContext().getRealPath("cmfw_img");
        service.deleteBanner(id,picPath,realPath);
    }

    //查一个
    @RequestMapping("/getOneBanner")
    public Banner getOneBanner(String id){
        return service.getOneBanner(id);
    }

    //修改
    @RequestMapping("/changeBanner")
    public void changeBanner(Banner banner){
       /* try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        service.changeBanner(banner);
    }
}
