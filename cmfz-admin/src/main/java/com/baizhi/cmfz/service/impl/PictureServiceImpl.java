package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjli on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;
    @Override
    public Map<String, Object> queryAllPciture(int start, int end) {
        List<Picture> pictures = pictureDao.selectAllPictureByPage(start-1,end);
        int count = pictureDao.pictureCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",pictures);
        return map;
    }

    @Override
    public Picture queryPictureById(String id) {
        return pictureDao.selectPictureById(id);
    }

    @Override
    public int addPicture(Picture picture) {
        picture.setPictureTime(new Date());
        return pictureDao.insertPicture(picture);
    }

    @Override
    public int modifyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }
}
