package com.hwua.crs.client.view;


import com.alibaba.fastjson.JSON;
import com.hwua.crs.client.Client;
import com.hwua.crs.client.entity.User;
import com.hwua.crs.client.util.InfoValue;
import com.hwua.crs.client.util.InputUtil;
import com.hwua.crs.client.util.SqlUtil;
import com.hwua.crs.client.util.MD5;

import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/6/12 9:57
 */
public class LoginView {
    public LoginView() {}
    public void login () {
        System.out.println("请输入用户名");
        String name = InputUtil.next().trim();
        System.out.println("请输入密码");
        String password = InputUtil.next().trim();
        password = MD5.getMd5(password);
        System.out.println();

        String sql = SqlUtil.querySql("SELECT * FROM t_user WHERE username = ?  AND password = ? ",InfoValue.USER);

        Client client = new Client();
        String result = client.link(sql,JSON.toJSONString(new User(name,password)));
        List<User> userJson = JSON.parseArray(result,User.class);
        if (userJson != null && userJson.size() == 1) {
            User user = userJson.get(0);
            System.out.println("登陆成功");
            if (user.getType() == 1) {
                //管理员界面
                System.out.println("管理员");
                new AdminView(user);
            }else {
                //用户界面
                System.out.println("用户");
                new UserInterfaceView(user);
            }
        }else {
            System.out.println("登陆失败(注意大小写)");
            System.out.println("1.重新登录  2.返回首页  Rest.退出");
            switch (InputUtil.next()){
                case "1":
                    this.login();
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
}
