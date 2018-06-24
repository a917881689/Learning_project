package com.hwua.crs.client.view;

import com.hwua.crs.client.util.InputUtil;

public class StartView {

    public static void main(String[] args) {
        new StartView().start();
    }
    public void start () {
        System.out.println("----------二嗨租车系统----------");
        System.out.println("===============================");
        System.out.println(" 1.登陆     2.注册     Rest.退出");

        switch (InputUtil.next()) {
            case "1":
                new LoginView().login();
                break;
            case "2":
                new RegisterView().register();
                break;
            default:
                System.exit(0);
        }
    }
}
