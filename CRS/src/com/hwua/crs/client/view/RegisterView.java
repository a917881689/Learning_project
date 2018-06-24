package com.hwua.crs.client.view;

import com.alibaba.fastjson.JSON;
import com.hwua.crs.server.entity.User;
import com.hwua.crs.client.Client;
import com.hwua.crs.client.util.InfoValue;
import com.hwua.crs.client.util.InputUtil;
import com.hwua.crs.client.util.SqlUtil;
import com.hwua.crs.client.util.MD5;

/**
 * @Author: yoSakura
 * @Date: 2018/6/12 9:57
 */
public class RegisterView {

    public void register () {
        System.out.println("——————注册界面————");

        System.out.println("请输入用户名");
        String name = InputUtil.next().trim();

        System.out.println("请输入密码");
        String password = InputUtil.next().trim();
        password = MD5.getMd5(password);
        System.out.println("请输入性别(0:女/1:男)");
        int sex = InputUtil.nextInt();

        System.out.println("请输入身份证号码");
        String idNumber = InputUtil.next().trim();

        System.out.println("请输入电话号码");
        String tel = InputUtil.next().trim();

        System.out.println("请输入地址");
        String address = InputUtil.next().trim();

        User user = new User(-1,name,password,sex,idNumber,tel,address,0);


        Client client = new Client();
        String sql = SqlUtil.userCheckSql("SELECT * FROM t_user WHERE username = ?");
        InfoValue result = InfoValue.getInfoValue(client.link(sql,JSON.toJSONString(user)));

        switch (result) {
            case ACCOUNT_NO_REPEAT:
                sql = SqlUtil.querySql("INSERT INTO t_user (id,username,password,sex,id_number,tel,addr,type) VALUES (t_user_id_seq.nextval,?,?,?,?,?,?,?)",InfoValue.USER);
                client.link(sql,JSON.toJSONString(user));
                System.out.println("注册成功!");
                new StartView().start();
                break;
            default:
                System.out.println(result);
                System.out.println("1.重新注册  2.返回首页  Rest.退出");
                this.choose();

        }
    }
    public void choose () {
        switch (InputUtil.next()){
            case "1":
                this.register();
                break;
            case "2":
                new StartView().start();
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
