package tset;


import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by mjli on 2018/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ArticleTest {
   @Autowired
    private ArticleDao articleDao;
    @Test
    public void teat1(){
        Article article = new Article("害怕","害怕著作",new Date(), "展示中", "10ecf67d832411e882020ed7d7530af8",new Master());
        System.out.println(articleDao.insertOne(article));
    }

    @Test
    public void test2(){
        List<Article> articles = articleDao.selectAllArticle(null,null);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

}
