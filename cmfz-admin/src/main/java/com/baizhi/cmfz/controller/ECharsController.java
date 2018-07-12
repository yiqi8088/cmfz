package com.baizhi.cmfz.controller;/**
 * Created by mjli on 2018/7/9.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @porgram:cmfz
 * @description:echars的控制层
 * @author:lih
 * @create:2018-07-09
 **/
@Controller
@RequestMapping("Echars")
public class ECharsController {

    @RequestMapping("man")
    @ResponseBody
    public String getMan(){
        return "{name: '北京',value: '100' },{name: '天津',value: randomData() },"+
                "{name: '上海',value: randomData() },{name: '重庆',value: randomData() }," +
                "{name: '河北',value: randomData() },{name: '河南',value: randomData() }," +
                "{name: '云南',value: randomData() },{name: '辽宁',value: randomData() }," +
                "{name: '黑龙江',value: randomData() },{name: '湖南',value: randomData()}," +
                "{name: '安徽',value: randomData() },{name: '山东',value: randomData() }," +
                "{name: '新疆',value: randomData() },{name: '江苏',value: randomData() }," +
                "{name: '浙江',value: randomData() },{name: '江西',value: randomData() }," +
                "{name: '湖北',value: randomData() },{name: '广西',value: randomData() }," +
                "{name: '甘肃',value: randomData() },{name: '山西',value: randomData() }," +
                "{name: '内蒙古',value: randomData() },{name: '陕西',value: randomData()}," +
                "{name: '吉林',value: randomData() },{name: '福建',value: randomData() }," +
                "{name: '贵州',value: randomData() },{name: '广东',value: randomData() }," +
                "{name: '青海',value: randomData() },{name: '西藏',value: randomData() }," +
                "{name: '四川',value: randomData() },{name: '宁夏',value: randomData() }," +
                "{name: '海南',value: randomData() },{name: '台湾',value: randomData() }," +
                "{name: '香港',value: randomData() },{name: '澳门',value: randomData() }";
    }

    @RequestMapping("woman")
    @ResponseBody
    public String getWoman(){
        return "{name: '北京',value: '100' },{name: '天津',value: randomData() },"+
                "{name: '上海',value: randomData() },{name: '重庆',value: randomData() }," +
                "{name: '河北',value: randomData() },{name: '河南',value: randomData() }," +
                "{name: '云南',value: randomData() },{name: '辽宁',value: randomData() }," +
                "{name: '黑龙江',value: randomData() },{name: '湖南',value: randomData()}," +
                "{name: '安徽',value: randomData() },{name: '山东',value: randomData() }," +
                "{name: '新疆',value: randomData() },{name: '江苏',value: randomData() }," +
                "{name: '浙江',value: randomData() },{name: '江西',value: randomData() }," +
                "{name: '湖北',value: randomData() },{name: '广西',value: randomData() }," +
                "{name: '甘肃',value: randomData() },{name: '山西',value: randomData() }," +
                "{name: '内蒙古',value: randomData() },{name: '陕西',value: randomData()}," +
                "{name: '吉林',value: randomData() },{name: '福建',value: randomData() }," +
                "{name: '贵州',value: randomData() },{name: '广东',value: randomData() }," +
                "{name: '青海',value: randomData() },{name: '西藏',value: randomData() }," +
                "{name: '四川',value: randomData() },{name: '宁夏',value: randomData() }," +
                "{name: '海南',value: randomData() },{name: '台湾',value: randomData() }," +
                "{name: '香港',value: randomData() },{name: '澳门',value: randomData() }";
    }

}
