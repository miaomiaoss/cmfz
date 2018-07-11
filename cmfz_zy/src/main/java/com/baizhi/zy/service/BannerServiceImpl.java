package com.baizhi.zy.service;


import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.dao.BannerDao;
import com.baizhi.zy.entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {

    @Resource(name = "bannerDao")
    private BannerDao dao;


    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Dto queryBanner(Integer page, Integer rows) {

        List<Banner> list = dao.queryBanner((page-1)*rows,rows);
        Integer count = dao.countBanner();

        return new Dto(count,list);
    }

    //添加
    @Override
    public void addBanner(MultipartFile pictureFile, HttpSession session, Banner banner) {
        String realPath = session.getServletContext().getRealPath("cmfw_img");

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = pictureFile.getOriginalFilename();
        String uuName = uuid + fileName;
        try {
            pictureFile.transferTo(new File(realPath+"/"+ uuName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        banner.setPicpath(uuName);

        String id = UUID.randomUUID().toString();
        banner.setId(id);
        dao.addBanner(banner);
    }

    //删除
    @Override
    public void deleteBanner(String id,String picPath,String realPath) {
        File file = new File(realPath + "/" + picPath);
        file.delete();
        dao.deleteBanner(id);
    }

    //修改
    @Override
    public void changeBanner(Banner banner) {
        System.out.println(banner);
        dao.changeBanner(banner);
    }
    //查一个
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Banner getOneBanner(String id) {

        return dao.getOneBanner(id);
    }
}
