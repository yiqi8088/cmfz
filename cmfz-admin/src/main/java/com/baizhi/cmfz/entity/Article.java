package com.baizhi.cmfz.entity;/**
 * Created by mjli on 2018/7/10.
 */

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @porgram:cmfz
 * @description:文章的实体类
 * @author:lih
 * @create:2018-07-10
 **/

public class Article implements Serializable {
    private String articleId;
    private String articleTitle;
    private String articleIntroduce;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date articleDate;
    private String articleStatus;
    private String masterId;
    private Master master = new Master();

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleIntroduce='" + articleIntroduce + '\'' +
                ", articleDate=" + articleDate +
                ", articleStatus='" + articleStatus + '\'' +
                ", masterId='" + masterId + '\'' +
                ", master=" + master +
                '}';
    }

    public Article() {
    }

    public Article(String articleTitle, String articleIntroduce, Date articleDate, String articleStatus, String masterId, Master master) {
        this.articleTitle = articleTitle;
        this.articleIntroduce = articleIntroduce;
        this.articleDate = articleDate;
        this.articleStatus = articleStatus;
        this.masterId = masterId;
        this.master = master;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleIntroduce() {
        return articleIntroduce;
    }

    public void setArticleIntroduce(String articleIntroduce) {
        this.articleIntroduce = articleIntroduce;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
