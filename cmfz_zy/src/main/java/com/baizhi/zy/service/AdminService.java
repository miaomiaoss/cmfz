package com.baizhi.zy.service;

import com.baizhi.zy.entity.Admin;

import java.util.Map;

public interface AdminService {


//  登陆
    public Map<Integer, Admin> login(Admin admin);

}
