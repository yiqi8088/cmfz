package com.baizhi.cmfz.dao;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @porgram:cmfz
 * @description:文章的dao层
 * @author:lih
 * @create:2018-07-10
 **/

public interface ArticleDao {
    /**
    *@Description:分页查询所有的文章
    *Author:lih
    *Date:2018/7/10
     **/
    public List<Article> selectAllArticle(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
    
    /**
    *@Description:添加一条文章
    *Author:lih
    *Date:2018/7/10
     **/
    public int insertOne(Article article);
    /**
    *@Description:修改一条文章
    *Author:lih
    *Date:2018/7/10
     **/
    public int updateOne(Article a);

    /**
    *@Description:查询所有行数
    *Author:lih
    *Date:2018/7/10
     **/
    public int count();
}
