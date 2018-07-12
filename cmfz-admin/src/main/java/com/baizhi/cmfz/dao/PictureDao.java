package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mjli on 2018/7/5.
 */
public interface PictureDao {

    public int insertPicture(@Param("picture") Picture picture);

    public int deletePicture(@Param("picture") Picture picture);

    public int updatePicture(@Param("picture") Picture picture);

    public List<Picture> selectAllPictureByPage(@Param("start")int start,@Param("end")int end);

    public Picture selectPictureById(@Param("id") String id);

    public int pictureCount();
}

