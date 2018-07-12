package com.baizhi.cmfz.dao;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @porgram:cmfz
 * @description:日志信息的dao层
 * @author:lih
 * @create:2018-07-10
 **/

public interface LogDao {
    public List<Log> selectLogByPage(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    public int insertLog(Log log);

}
