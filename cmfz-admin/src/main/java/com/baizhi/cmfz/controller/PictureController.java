package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mjli on 2018/7/5.
 */
@Controller
@RequestMapping("picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    /**
    *@Description:分页查询所有的轮播图
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("showPictureByPage")
    @ResponseBody
    public Map<String, Object> showAll(@RequestParam("page")int start,@RequestParam("rows")int end){
        return pictureService.queryAllPciture(start,end);
    }
    /**
    *@Description:根据Id查询轮播图
    *Author:lih
    *Date:2018/7/10
    @RequestMapping("showPictureById")
    @ResponseBody
    **/
    public Picture showPictureById(String id){

        return pictureService.queryPictureById(id);

    }
    /**
    *@Description:添加一个轮播图
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("addPicture")
    @ResponseBody
    public String addPciture(Picture picture, MultipartFile myFile, HttpSession session,String pictureStatus) throws IOException {
        String realPath = session.getServletContext().getRealPath("/");
        System.out.println(realPath+realPath.length());
        int indexOf = realPath.lastIndexOf("\\");
        System.out.println(indexOf);

        String realPath1 = realPath.substring(0,indexOf);
        int indexOf1 = realPath1.lastIndexOf("\\");
        String path = realPath1.substring(0,indexOf1)+"/upload/";
        System.out.println(path);
        System.out.println(realPath);
        String uuidName = UUID.randomUUID().toString().replace("-","");
        //获取文件的后缀名
        String oldName = myFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        picture.setPictureName(uuidName+suffix);
        picture.setPicturePath(path+"/"+uuidName+suffix);
        System.out.println(pictureStatus);
        picture.setPictureStatue(pictureStatus);
        int i = pictureService.addPicture(picture);
        System.out.println(picture);
        myFile.transferTo(new File(path+"/"+uuidName+suffix));
        if(i > 0){
            return "success";
        }else{
            return "error";
        }

    }
    /**
    *@Description:修改轮播图
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("modifyPicture")
    @ResponseBody
    public String modifyPicture(Picture picture, MultipartFile myFile, HttpSession session,String pictureStatus) throws IOException {
        System.out.println(picture+"++++"+myFile.getName()+"++++"+pictureStatus);
        if(!myFile.isEmpty()){
            String realPath = session.getServletContext().getRealPath("/");
            System.out.println(realPath+realPath.length());
            int indexOf = realPath.lastIndexOf("\\");
            String realPath1 = realPath.substring(0,indexOf);
            int indexOf1 = realPath1.lastIndexOf("\\");
            String path = realPath1.substring(0,indexOf1)+"/upload/";
            String uuidName = UUID.randomUUID().toString().replace("-","");
            String oldName = myFile.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            myFile.transferTo(new File(path+"/"+uuidName+suffix));
            picture.setPictureName(uuidName+suffix);
            picture.setPicturePath(path+"/"+uuidName+suffix);
            picture.setPictureTime(new Date());
        }
        picture.setPictureStatue(pictureStatus);
        System.out.println(picture);
        int i = pictureService.modifyPicture(picture);
        System.out.println(i);
        if(i>0){
            return "success";
        }else{
            return "error";
        }
    }


}
