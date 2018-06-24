package com.hwua.crs.server;

import com.alibaba.fastjson.JSON;
import com.hwua.crs.server.entity.Car;
import com.hwua.crs.server.service.impl.IUserServiceImpl;
import com.hwua.crs.server.util.ConnectionFactory;
import com.hwua.crs.server.util.InfoValue;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/5/31 17:44
 */
public class ThreadTest implements Runnable{
    private Socket socket;

    public ThreadTest(Socket socket) {
        this.socket = socket;
    }

    /**
     * 写入本地
     */
    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            //字符输入流
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            //字符输出流
            pw = new PrintWriter(socket.getOutputStream(),true);

            //读取标识符+sql语句信息
            String read = br.readLine();
            //分割信息存储进String数组
            String[] strArray = read.split(InfoValue.IDENTIFICATION.toString());
            //读取标识符
            InfoValue choose = InfoValue.getInfoValue(strArray[0]);
            //读取sql语句
            String sql = strArray[1];
            //读取类标识
            InfoValue infoValue = InfoValue.getInfoValue(strArray[2]);

            //读取条件对象信息
            String infoStr = br.readLine();
            Object obj;

            //判断条件对象是否为空
            if (infoStr != null && !"".equals(infoStr)) {
                obj = JSON.parseObject(infoStr,Object.class);
            }else {
                obj = null;
            }
            //第二次读取条件对象信息
            infoStr = br.readLine();

            String result = null;
            switch (choose) {
                //账号检查
                case ACCOUNT_CHECK:
                    result = new IUserServiceImpl().queryName(sql,obj,infoValue).getInfo();
                    break;
                    //查询语句
                case SELECT:
                    result = new IUserServiceImpl().query(sql,obj,infoValue);
                    break;
                    //修改语句
                case UPDATE:
                    result = new IUserServiceImpl().update(sql,obj,infoValue);
                    break;
                    //双重修改语句
                case DOUBLE_UPDATE:
                    Object obj2 = JSON.parseObject(infoStr,Object.class);
                    String[] sqlArray = {sql,strArray[3]};
                    Object[] objAray = {obj,obj2};
                    InfoValue[] info = {infoValue,InfoValue.getInfoValue(strArray[4])};
                    result = new IUserServiceImpl().update(sqlArray,objAray,info);
                    break;
                case EXCEL_CAR:
                    List<Car> carList = JSON.parseArray(infoStr,Car.class);
                    result = new IUserServiceImpl().update(sql,carList,infoValue);
                    break;
                default:
                    break;
            }
            //返回结果信息
            pw.println(result);

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            ConnectionFactory.close(pw,br);
        }
    }
}
