package com.utils.decode;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: Maple
 * @Date: 2021/2/5
 */
public class DecodeUtils {
    //返回中文字符
    static public String DecodeFromPath(String username){
        try {
            username = new String(username.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return username;
    }
}
