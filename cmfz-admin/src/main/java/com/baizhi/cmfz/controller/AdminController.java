package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.CreateValidateCode;
import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;

/**
 * Created by mjli on 2018/7/4.
 */
@Controller
@RequestMapping("admin")
@SessionAttributes(value = {"vCode"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("vCode")
    public void getCode(HttpServletResponse response, Model model) throws IOException {
        CreateValidateCode validateCode = new CreateValidateCode(100, 30, 1, 10);
        model.addAttribute("vCode", validateCode.getCode());
        validateCode.write(response.getOutputStream());
    }

    @RequestMapping("/verify")
    public String login(String adminName, String adminPwd, String enCode, String checkbox, boolean remeberMe, Model model, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(adminName + "+" + adminPwd + "+" + enCode);
        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("vCode");
        System.out.println(vCode);
        Subject subject = SecurityUtils.getSubject();
        if (vCode.equals(enCode)) {
            try {
                subject.login(new UsernamePasswordToken(adminName, adminPwd, remeberMe));
                return "redirect:/main.jsp";
            } catch (UnknownAccountException e) {//账号不存异常
                e.printStackTrace();
                return "redirect:/login.jsp";
            } catch (IncorrectCredentialsException e) {//无效的认证凭证异常
                e.printStackTrace();
                return "redirect:/login.jsp";
            } catch (AuthenticationException e) { //认证异常
                e.printStackTrace();
                return "redirect:/login.jsp";
            }
        }
        return "redirect:/login.jsp";
    }
}

