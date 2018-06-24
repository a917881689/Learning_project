package com.hwua.crs.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hwua.crs.client.util.SqlUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: yoSakura
 * @Date: 2018/5/31 17:32
 */
public class Client {
    public String link (String sql,String objStr,String objStr2) {
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        String info = null;
        try {
            socket = new Socket("127.0.0.1", 3944);
            pw = new PrintWriter(socket.getOutputStream(),true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (sql != null) {
                pw.println(sql);
            }else {
                System.out.println("程序错误,自动退出");
                System.exit(0);
            }
            if (objStr != null) {
                pw.println(objStr);
            }else {
                pw.println();
            }
            if (objStr2 != null) {
                pw.println(objStr);
            }else {
                pw.println();
            }
            info = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器连接失败");
        } finally {
            SqlUtil.close(socket,pw,br);
        }
        if("null".equals(info)) {
            return null;
        }
        return info;
    }
    public String link (String sql,String json) {
        return this.link(sql,json,null);
    }

}
