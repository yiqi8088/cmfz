package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by mjli on 2018/7/6.
 */
public interface MasterDao {

    public List<Master> selectAllByPage(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    public int insertMaster(Master master);

    public int updateMaster(Master master);

    /**
    *@Description:批量插入
    *Author:lih
    *Date:2018/7/9
     **/
    public int insertMasertList(@Param("masters")List<Master> masters);
    /**
    *@Description:模糊查询
    *Author:lih
    *Date:2018/7/9
     **/
    public List<Master> selecyMasterByKey(@Param("key") String key,@Param("value") String value,@Param("start") int start,@Param("pageSize") int pageSize);
    /**
    *@Description:根据条件查询所有的行数
    *Author:lih
    *Date:2018/7/9
     **/
    public int countByKey(@Param("key")String key, @Param("value")String value);
}
