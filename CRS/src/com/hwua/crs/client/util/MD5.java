package com.hwua.crs.client.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: yoSakura
 * @Date: 2018/6/21 11:03
 */
public class MD5 {
    public static String getMd5 (String password) {
        //【关键点一：】MessageDigest.getInstance("MD5").digest("需要加密的字符".getBytes())计算出来的结果返回的byte[]长度始终为16位。
        //【关键点二：】要记住我们计算出来的md5(32位)最后都都是固定长度32的字符串
        StringBuffer pwd = new StringBuffer();
        //信息摘要算法的功能，如 MD5 或 SHA 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            //通过使用 update 方法处理数据,使指定的 byte数组更新摘要
            md5.update(password.getBytes());
            for (Byte b:md5.digest()) {
                //0XFF是255 255的的二进制为
                //0000 0000 0000 0000 0000 0000 1111 1111
                //& 运算符 相同为真,不同为假(0);
                //相当于取低八位的数值;
                int k = b & 0Xff;
                //10进制转16进制,X表示以十六进制形式输出,02表示不足两位前面补0输出;
                pwd.append(String.format("%02X",k));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pwd.toString();

    }
}
