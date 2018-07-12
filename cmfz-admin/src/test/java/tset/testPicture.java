package tset;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by mjli on 2018/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testPicture {
    @Autowired
    private PictureDao pictureDao;
    @Test
    public void test1(){
        Picture picture = new Picture("044b466880fb11e882020ed7d7530af8", "218d1af780764661a39142552618aaa6.jpg", "这是滴滴", null,null, "展示中");
        System.out.println(pictureDao.updatePicture(picture));
    }
    @Test
    public void test2(){
        System.out.println(pictureDao.selectPictureById("cbf6e2ee805711e882020ed7d7530af8"));

    }
}
