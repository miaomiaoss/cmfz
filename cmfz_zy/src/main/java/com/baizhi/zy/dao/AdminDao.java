package com.baizhi.zy.dao;

import com.baizhi.zy.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    Admin getOneAdmin(String name);

}
