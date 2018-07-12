package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mjli on 2018/7/5.
 */
public class Picture implements Serializable {
    private String pictureId;
    private String pictureName;
    private String pictureDescription;
    private String picturePath;
    @JSONField(format = "yyyy-MM-dd hh:mm:dd")
    private Date pictureTime;
    private String pictureStatus;

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", pictureDescription='" + pictureDescription + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureTime=" + pictureTime +
                ", pictureStatue='" + pictureStatus + '\'' +
                '}';
    }

    public Picture() {
    }

    public Picture(String pictureId, String pictureName, String pictureDescription, String picturePath, Date pictureTime, String pictureStatus) {
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.pictureDescription = pictureDescription;
        this.picturePath = picturePath;
        this.pictureTime = pictureTime;
        this.pictureStatus = pictureStatus;
    }

    public Picture(String pictureName, String pictureDescription, String picturePath, Date pictureTime, String pictureStatus) {
        this.pictureName = pictureName;
        this.pictureDescription = pictureDescription;
        this.picturePath = picturePath;
        this.pictureTime = pictureTime;
        this.pictureStatus = pictureStatus;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Date getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(Date pictureTime) {
        this.pictureTime = pictureTime;
    }

    public String getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatue(String pictureStatus) {
        this.pictureStatus = pictureStatus;
    }
}
