package com.baizhi.cmfz.service.impl;/**
 * Created by mjli on 2018/7/9.
 */

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @porgram:cmfz
 * @description:MasterService 的实现类
 * @author:lih
 * @create:2018-07-09
 **/
@Service
@Transactional
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterDao masterDao;
    @Override
    public Map<String, Object> queryAllMaster(int start, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        int i = (start -1)*pageSize;
        List<Master> masters = masterDao.selectAllByPage(i,pageSize);
        int count = masterDao.countByKey(null,null);
        map.put("total",count);
        map.put("rows",masters);
        return map;
    }

    @Override
    public int addMaster(Master master) {
        return masterDao.insertMaster(master);
    }

    @Override
    public int modifyMaster(Master master) {
        return masterDao.updateMaster(master);
    }

    @Override
    public Map<String, Object> queryMasterByKey(String key, String value, int start, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        int i = (start -1)*pageSize;
        List<Master> masters = masterDao.selecyMasterByKey(key,value,i,pageSize);
        int count = masterDao.countByKey(key,value);
        map.put("total",count);
        map.put("rows",masters);
        return map;
    }

    @Override
    public int addListMaster(List<Master> masters) {
        return masterDao.insertMasertList(masters);
    }

    @Override
    public List<Master> queryMaster() {
        return masterDao.selectAllByPage(null,null);
    }
}
