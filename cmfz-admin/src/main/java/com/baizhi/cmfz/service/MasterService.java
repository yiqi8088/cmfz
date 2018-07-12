package com.baizhi.cmfz.service;/**
 * Created by mjli on 2018/7/9.
 */

import com.baizhi.cmfz.entity.Master;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * @porgram:cmfz
 * @description:This is MasterService
 * @author:lih
 * @create:2018-07-09
 **/

public interface MasterService {
    /**
    *@Description:分页查询所有上师
    *Author:lih
    *Date:2018/7/9
     **/
    public Map<String,Object> queryAllMaster(int start, int pageSize);
    /**
    *@Description:添加一个上师的信息
    *Author:lih
    *Date:2018/7/9
     **/
    public int addMaster(Master master);
    /**
    *@Description:修改一个上师的信息
    *Author:lih
    *Date:2018/7/9
     **/
    public int modifyMaster(Master master);
    /**
    *@Description:模糊查询master,分页显示
    *Author:lih
    *Date:2018/7/9
     **/
    public Map<String,Object> queryMasterByKey(String key, String value, int start, int pageSize);
    /**
    *@Description:easypoi excle 插入
     *Author:lih
    *Date:2018/7/9
    **/
    public int addListMaster(List<Master> masters);

    public List<Master> queryMaster();

}
