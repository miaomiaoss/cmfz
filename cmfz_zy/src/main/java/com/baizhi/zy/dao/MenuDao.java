package com.baizhi.zy.dao;

import com.baizhi.zy.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {

    //查所有菜单
    List<Menu> queryAllMenu();
}
