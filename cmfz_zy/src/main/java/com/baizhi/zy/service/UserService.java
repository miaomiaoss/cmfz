package com.baizhi.zy.service;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.Dto.UserDto;
import com.baizhi.zy.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface UserService {

    Dto queryAllUser(Integer page, Integer rows);

    //    查询用户创建信息
    UserDto countUser();

    //    导入用户信息
    void importUser(MultipartFile file, HttpSession session);
}
