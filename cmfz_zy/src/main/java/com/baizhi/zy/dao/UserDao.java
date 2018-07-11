package com.baizhi.zy.dao;

import com.baizhi.zy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> queryAllUser(@Param("page") Integer page, @Param("rows") Integer rows);

    Integer countUser();
    //  导入用户信息
    void importUser(List<User> users);

//    查询一周内创建的用户
    Integer queryOneWeek();
//    查询半个月内创建的用户
    Integer queryTwoWeek();
//    查询一年内创建的用户
    Integer queryOneYear();


}
