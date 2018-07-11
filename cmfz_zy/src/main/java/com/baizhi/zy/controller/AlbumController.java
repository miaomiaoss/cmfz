package com.baizhi.zy.controller;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.entity.Album;
import com.baizhi.zy.service.AlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class AlbumController {

    @Resource(name = "albumService")
    private AlbumService service;

    //查所有专辑
    @RequestMapping(value = "/queryAlbum", produces = "text/plain;charset=UTF-8")
    public Dto queryAllAlbum(Integer page, Integer rows){
        return service.queryAllAlbum(page,rows);
    }

    //添加专辑
    @RequestMapping("/insertAlbum")
    public void insertAlbum(MultipartFile pictureFile, HttpSession session, Album album){
        service.insertAlbum(pictureFile,session,album);
    }
}
