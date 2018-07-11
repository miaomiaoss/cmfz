package com.baizhi.zy.service;

import com.baizhi.zy.dao.AdminDao;
import com.baizhi.zy.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

    @Resource(name = "adminDao")
    private AdminDao dao;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<Integer, Admin> login(Admin admin) {

        Map<Integer, Admin> map = new HashMap<>();
        Admin a = dao.getOneAdmin(admin.getName());

        if (a == null) {
            map.put(0, null);
        } else if (!a.getPassword().equals(admin.getPassword())) {
            map.put(0, null);
        } else {
            map.put(1, a);
        }

        return map;
    }
}
