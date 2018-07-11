package com.baizhi.zy.service;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


public interface AlbumService {
    Dto queryAllAlbum(Integer page, Integer rows);

    //添加专辑
    void insertAlbum(MultipartFile pictureFile, HttpSession session, Album album);
}
