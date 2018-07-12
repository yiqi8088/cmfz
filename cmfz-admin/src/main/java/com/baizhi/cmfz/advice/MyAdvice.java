package com.baizhi.cmfz.advice;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @porgram:cmfz
 * @description:aspectJ额外功能类
 * @author:lih
 * @create:2018-07-10
 **/

@Aspect
public class MyAdvice {
    @Autowired
    private LogService logService;
    private HttpSession session;
    /**
    *@Description:指定切入点
    *Author:lih
    *Date:2018/7/10
     **/
    @Pointcut("!execution(* com.baizhi.cmfz.service.impl.MasterServiceImpl.query*(..)) || !execution(* com.baizhi.cmfz.service.impl.PictureServiceImpl.query*(..))")
    public void pc(){}

    /**
    *@Description:环绕通知,添加入职
    *Author:lih
    *Date:2018/7/10
     **/
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Log log = new Log();

        //获取当前用户
        String adminName = (String) session.getAttribute("adminName");
        System.out.println(adminName);
        //获取参数列表
        Object[] args = pjp.getArgs();

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();//获取当前方法
        //获取当前方法对象
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        String operation = null;
        //判断 methodName 是否以指定字符串开头
        if(methodName.startsWith("add")){
            operation = "新增";
        }
        if(methodName.startsWith("modify")){
            operation = "修改";
        }
        if(methodName.startsWith("remove")){
            operation = "删除";
        }
        System.out.println(operation);
        log.setLogTime(new Date());
        log.setLogUser(adminName);
        //获取类的对象
        Class clazz = pjp.getTarget().getClass();
        System.out.println("--------clazz-------------"+clazz.getName());
        //获取全限定名
        String classFromName = clazz.getName();
        String className = classFromName.substring(classFromName.lastIndexOf(".")+1).replace("ServiceImpl","");
        log.setLogResource(className);
        log.setLogAction(operation);
        String message = "";
        for (Object arg : args) {
            message += arg.toString();
        }
        log.setLogMessage(message);
        String result = "success";
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            result = "failure";
        } finally {
            log.setLogResult(result);
            logService.addLog(log);
        }
        System.out.println(log);
        return obj;
    }
}
