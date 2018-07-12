package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * Created by mjli on 2018/7/5.
 */
public interface PictureService {
    public Map<String,Object> queryAllPciture(int start, int end);

    public Picture queryPictureById(String id);

    public int addPicture(Picture picture);

    public int modifyPicture(Picture picture);
}
