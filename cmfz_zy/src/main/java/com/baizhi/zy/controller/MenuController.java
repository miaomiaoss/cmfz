package com.baizhi.zy.controller;

import com.baizhi.zy.entity.Menu;
import com.baizhi.zy.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MenuController {

    @Resource(name = "menuService")
    private MenuService service;

    //显示功能栏
    @RequestMapping("/queryMenu")
    public List<Menu> queryMenu(){
        return service.queryAllMenu();
    }
}
