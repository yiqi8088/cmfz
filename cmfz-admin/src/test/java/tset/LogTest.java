package tset;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @porgram:cmfz
 * @description:日志的测试类
 * @author:lih
 * @create:2018-07-10
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LogTest {
    @Autowired
    private LogDao logDao;
    @Test
    public void  test1(){
        Log log = new Log("haha",new Date(),"picture","增加","增加一个轮播图","success");
        System.out.println(logDao.selectLogByPage(0,5));
    }
}
