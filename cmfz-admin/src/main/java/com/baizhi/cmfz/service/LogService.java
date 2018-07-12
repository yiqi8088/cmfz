package com.baizhi.cmfz.service;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Log;

import java.util.List;

/**
 * @porgram:cmfz
 * @description:日志的Service层
 * @author:lih
 * @create:2018-07-10
 **/

public interface LogService {
    /**
    *@Description:插入日志信息
    *Author:lih
    *Date:2018/7/10
     **/
    public int addLog(Log log);
    /**
    *@Description:分页查询日志信息
    *Author:lih
    *Date:2018/7/10
     **/
    public List<Log> queryAll(Integer start,Integer pageSize);
}
