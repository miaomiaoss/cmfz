package com.baizhi.zy.service;

import com.baizhi.zy.Dto.Dto;
import com.baizhi.zy.Dto.UserDto;
import com.baizhi.zy.dao.UserDao;
import com.baizhi.zy.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao dao;

    //查所有user
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Dto queryAllUser(Integer page, Integer rows) {

        List<User> list = dao.queryAllUser((page-1)*rows,rows);
        Integer count = dao.countUser();

        return new Dto(count, list);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserDto countUser() {
        Integer oneWeek = dao.queryOneWeek();
        Integer twoWeek = dao.queryTwoWeek();
        Integer oneYear = dao.queryOneYear();
        int[] a = {oneWeek,twoWeek,oneYear};

        return new UserDto(a);
    }

    @Override
    public void importUser(MultipartFile file, HttpSession session) {

    }


}
