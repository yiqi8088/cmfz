package tset;/**
 * Created by mjli on 2018/7/9.
 */

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @porgram:cmfz
 * @description:Master测试类
 * @author:lih
 * @create:2018-07-09
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class masterTest {
    @Autowired
    private MasterDao masterDao;
    @Autowired
    private MasterService masterService;
    @Test
    public void test1(){
        Master master1 = new Master("72b18ce3837a11e882020ed7d7530af8","哆啦A梦大师",null,"健在");
        System.out.println(masterService.modifyMaster(master1));

    }
    @Test
    public void Test2(){
        List<Master> masters = new ArrayList<Master>();
        Master master1 = new Master("哆啦A梦大师5","c.jpg","健在");
        Master master2 = new Master("哆啦A梦大师6","d.jpg","健在");
        masters.add(master1);
        masters.add(master2);
        System.out.println( masterService.addListMaster(masters));
    }

}
