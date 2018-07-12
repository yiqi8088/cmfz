package com.baizhi.cmfz.service.impl;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @porgram:cmfz
 * @description:日志的Service的实现类
 * @author:lih
 * @create:2018-07-10
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public int addLog(Log log) {
        return logDao.insertLog(log);
    }

    @Override
    public List<Log> queryAll(Integer start, Integer pageSize){
        Integer i = (start -1)*pageSize;
        return logDao.selectLogByPage(i,pageSize);
    }
}
