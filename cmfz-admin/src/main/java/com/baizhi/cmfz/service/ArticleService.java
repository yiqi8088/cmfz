package com.baizhi.cmfz.service;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @porgram:cmfz
 * @description:文章的Service层
 * @author:lih
 * @create:2018-07-10
 **/

public interface ArticleService {
    /**
    *@Description:分页查询文章信息
    *Author:lih
    *Date:2018/7/10
     **/
    public Map<String ,Object> queryAllArticle(Integer start, Integer pageSize);
    /**
    *@Description:增加一个文章信息
    *Author:lih
    *Date:2018/7/10
     **/
    public int addArticle(Article article);
}
