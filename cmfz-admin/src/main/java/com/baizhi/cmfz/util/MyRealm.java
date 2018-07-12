package com.baizhi.cmfz.util;/**
 * Created by mjli on 2018/7/12.
 */

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @porgram:cmfz
 * @description:自定义数据源类
 * @author:lih
 * @create:2018-07-12
 **/

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDao adminDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /**
    *@Description:认证信息
    *Author:lih
    *Date:2018/7/12
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if(adminDao.selectAdminByName(username) != null){
            String password = adminDao.selectAdminByName(username).getAdminPwd();
            String salt = adminDao.selectAdminByName(username).getAdminSalt();
            //返回加密的信息进行匹配
            System.out.println(password+"+"+salt);
            return new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(salt), UUID.randomUUID().toString());
        }
        return null;

    }
}
