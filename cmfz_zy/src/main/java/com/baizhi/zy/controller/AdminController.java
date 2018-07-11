package com.baizhi.zy.controller;

import com.baizhi.zy.entity.Admin;
import com.baizhi.zy.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
public class AdminController {

    @Resource(name = "adminService")
    private AdminService service;

    //登陆
    @RequestMapping("/login")
    public String login(HttpSession session, Admin admin, String enCode){

        String code = (String) session.getAttribute("vrifyCode");

        if (code.equals(enCode)) {
            Map<Integer, Admin> map = service.login(admin);

            if (map.containsKey(0)){
                return "0";//登陆失败返回0
            }
            else{
                session.setAttribute("Admin",map.get(1));
                return "1";//登陆成功返回1
            }
        }else{
            System.out.println("------");
            return "0";
        }
    }

    //退出
    @RequestMapping("/exit")
    public void exit(HttpSession session){
        session.setAttribute("Admin",null);
    }

}
