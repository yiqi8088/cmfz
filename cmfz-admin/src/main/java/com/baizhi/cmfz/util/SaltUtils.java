package com.baizhi.cmfz.util;

import java.util.Random;

/**
 * Created by mjli on 2018/7/4.
 */
public class SaltUtils {

    public static String getRandom(int len){
        char[] chs = "abcdefg1234567ABCDEFG".toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder =new StringBuilder();
        for(int i = 0; i< len; i++){
            stringBuilder.append(chs[random.nextInt(chs.length)]);
        }
        return stringBuilder.toString();
    }
}
