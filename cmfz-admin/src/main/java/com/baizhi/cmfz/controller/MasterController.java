package com.baizhi.cmfz.controller;
/**
 * Created by mjli on 2018/7/9.
 */

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @porgram:cmfz
 * @description:Maste的controller控制层
 * @author:lih
 * @create:2018-07-09
 **/
@Controller
@RequestMapping("master")
public class MasterController {

    @Autowired
    private MasterService masterService;
    /**
    *@Description:分页显示所有的master信息
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("showAllMaster")
    @ResponseBody()
    public Map<String,Object> showAllMaster(@RequestParam("page")Integer page,@RequestParam("rows")Integer rows){
        return masterService.queryAllMaster(page,rows);
    }
    /**
    *@Description:通过条件查找上师
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("showMasterByKey")
    @ResponseBody
    public Map<String,Object> showMasterByKey(String key,String value,@RequestParam("page")Integer page,@RequestParam("rows")Integer rows){
        return masterService.queryMasterByKey(key,value,page,rows);
    }
    /**
    *@Description:添加上师
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("addMaster")
    @ResponseBody
    public String addMaster(Master master, MultipartFile myFile, HttpSession session) throws IOException {
        //获取文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        String realpath1 = realPath.substring(0,realPath.lastIndexOf("\\"));
        String path = realpath1.substring(0,realpath1.lastIndexOf("\\"))+"/upload/";
        System.out.println(path);
        String uuidName = UUID.randomUUID().toString().replace("-","");
        String oldName = myFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        System.out.println("suffix:"+suffix);
        myFile.transferTo(new File(path+"/"+uuidName+suffix));
        master.setMasterPhoto(uuidName+suffix);
        int i = masterService.addMaster(master);
        if (i > 0){
            return "success";
        }else {
            return "error";
        }
    }
    /**
    *@Description:修改上师
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("modifyMaster")
    @ResponseBody
    public String modifyMaster(Master master,MultipartFile myFile,HttpSession session) throws IOException {
            System.out.println(master);
        if(!myFile.isEmpty()){
            String realPath = session.getServletContext().getRealPath("/");
            String realpath1 = realPath.substring(0,realPath.lastIndexOf("\\"));
            String path = realpath1.substring(0,realpath1.lastIndexOf("\\"))+"/upload/";
            System.out.println(path);
            String uuidName = UUID.randomUUID().toString().replace("-","");
            String oldName = myFile.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            System.out.println("suffix:"+suffix);
            myFile.transferTo(new File(path+"/"+uuidName+suffix));
            master.setMasterPhoto(uuidName+suffix);
        }
        int i = masterService.modifyMaster(master);
        System.out.println(i);
        if (i > 0){
            return "success";
        }else {
            return "error";
        }
    }
    /**
    *@Description:用poi批量导入上师
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("excelUpload")
    @ResponseBody
    public String addMasterByPoi(MultipartFile myFile) {
        ImportParams importParams = new ImportParams();
        try {
            List<Master> masters = ExcelImportUtil.importExcel(myFile.getInputStream(),Master.class,importParams);
            for (Master master : masters) {
                System.out.println(master);
            }
            int i = masterService.addListMaster(masters);
            System.out.println(i);
            if(i > 0){
                return "success";
            }else{
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    /**
    *@Description:导出上师资料
    *Author:lih
    *Date:2018/7/9
     **/
    @RequestMapping("export")
    @ResponseBody
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Master> masters = masterService.queryMaster();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118","上师信息表"),Master.class,masters);
        ServletOutputStream out = response.getOutputStream();
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1
        String fileName = new String("上师信息表.xls".getBytes(),"iso-8859-1");
        response.setContentType("application/vnd.ms-excel");//响应类型  text/html  application/json
        response.setHeader("content-disposition","attachment;fileName="+fileName);

        workbook.write(out);
        out.close();
    }
    /**
    *@Description:显示所有上师的名字
    *Author:lih
    *Date:2018/7/10
     **/
    @RequestMapping("showName")
    @ResponseBody
    public List<Master> queryAllGuru(){
        return masterService.queryMaster();
    }
}
