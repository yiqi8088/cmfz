package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

/**
 * Created by mjli on 2018/7/4.
 */
public interface AdminService {

    public Admin Login(String name, String pwd);

    public int regist(Admin admin);
}
