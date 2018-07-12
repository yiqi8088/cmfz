package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mjli on 2018/7/4.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin Login(String name, String pwd) {
        Admin admin = null;
        Admin temp = adminDao.selectAdminByName(name);
        if(temp != null){
            String salt = temp.getAdminSalt();
            if(temp.getAdminPwd().equals(DigestUtils.md5Hex(salt.concat(pwd)))){
                admin = temp;
            }
        }
        return admin;
    }

    @Override
    public int regist(Admin admin) {
        if(adminDao.selectAdminByName(admin.getAdminName()) != null){
            return 0;
        }
        String salt = SaltUtils.getRandom(6);
        admin.setAdminSalt(salt);
        String pwd = admin.getAdminPwd();
        admin.setAdminPwd(DigestUtils.md5Hex(salt.concat(pwd)));
        int i = adminDao.insertAdmin(admin);
        return i ;
    }
}
