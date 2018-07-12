package com.baizhi.cmfz.controller;/**
 * Created by mjli on 2018/7/10.
 */

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.RichTextString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @porgram:cmfz
 * @description:文章的Controller层
 * @author:lih
 * @create:2018-07-10
 **/
@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    /**
    *@Description:分页显示文章
    *Author:lih
    *Date:2018/7/10
     * Param:参数一：当前页，参数二：每页条数
     **/
    @RequestMapping("showArticles")
    @ResponseBody
    public Map<String,Object> showAllArticle(@RequestParam("page") int start, @RequestParam("rows") int pageSize){
        Map<String,Object> map = articleService.queryAllArticle(start,pageSize);
        List<Article> articles = (List<Article>) map.get("rows");
        for (Article article : articles) {
            System.out.println(article);
        }
        return map;
    }
    /**
    *@Description:多文件上传
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("upload")
    @ResponseBody
    public RichTextResult  uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request){
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            System.out.println(realPath);
            String path= realPath.substring(0,realPath.lastIndexOf("\\"));
            System.out.println(path);
            String uploadPath = path.substring(0,path.lastIndexOf("\\"))+"\\upload";
            System.out.println(uploadPath);
            System.out.println(files.length);
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));
                    System.out.println(fileName);
                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    System.out.println("path:"+request.getContextPath().toString());
                    data.add("cmfz-admin/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
    /**
    *@Description:添加文章
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("/addArticle")
    @ResponseBody
    public Integer addArticle(Article article){
        System.out.println(article);
        return articleService.addArticle(article);
    }
}

