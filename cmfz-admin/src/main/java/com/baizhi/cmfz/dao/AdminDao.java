package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by mjli on 2018/7/4.
 */
public interface AdminDao {

    public Admin selectAdminByName(@Param("name") String name);

    public Admin selectAdminById(@Param("id") String id);

    public int insertAdmin(@Param("admin") Admin admin);

    public int updateAdmin(@Param("admin") Admin admin);

    public int deleteAdminById(@Param("id") String id);
}
