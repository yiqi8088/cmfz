package tset;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.impl.MenuServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mjli on 2018/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MenuTest {
    @Autowired
    private MenuDao  menuDao;
    @Autowired
    private MenuService menuService;
    @Test
    public void tsetDao(){
        List<Menu> menus = menuDao.selectAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void testService(){
        List<Menu> menus = menuService.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }

    }


}
