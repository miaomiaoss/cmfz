package com.baizhi.zy.service;

import com.baizhi.zy.dao.MenuDao;
import com.baizhi.zy.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource(name = "menuDao")
    private MenuDao dao;

    @Override
    public List<Menu> queryAllMenu() {

        return dao.queryAllMenu();
    }
}
