package com.baizhi.cmfz.service.impl;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @porgram:cmfz
 * @description:文章Service层的实现类
 * @author:lih
 * @create:2018-07-10
 **/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public Map<String, Object> queryAllArticle(Integer start, Integer pageSize) {
        int i = (start -1)*pageSize;
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = articleDao.count();
        List<Article> articles = articleDao.selectAllArticle(i,pageSize);
        map.put("total",count);
        map.put("rows",articles);
        return map;
    }

    @Override
    public int addArticle(Article article) {
        return articleDao.insertOne(article);
    }
}
