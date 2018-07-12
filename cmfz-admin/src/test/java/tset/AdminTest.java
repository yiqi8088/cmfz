package tset;


import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;

/**
 * Created by mjli on 2018/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class AdminTest {
    @Resource(name = "adminDao")
    private AdminDao adminDao;

    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Admin admin = new Admin("tom123","123456","aaa",1);
        System.out.println(adminDao.insertAdmin(admin));

    }
    @Test
    public void test2(){
        System.out.println(adminDao.selectAdminByName("tom123"));
    }
    @Test
    public void test3(){
        Admin admin = new Admin();
        admin.setAdminName("haha");
        admin.setAdminPwd("123456");
        admin.setAdminStatus(0);
        System.out.println(adminService.regist(admin));
    }
    @Test
    public void test4(){
        System.out.println(adminService.Login("haha1","123456"));
    }
    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
