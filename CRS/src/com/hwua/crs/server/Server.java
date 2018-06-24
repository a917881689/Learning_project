package com.hwua.crs.server;

import com.hwua.crs.server.util.MyThreadFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: yoSakura
 * @Date: 2018/5/31 17:32
 */
public class Server {
    public static void main (String[] args) {
        try {
            System.out.println("服务器已打开!");
            ServerSocket serverSocket = new ServerSocket(3944);
            Thread thread;
            while (true) {
                //等待客户端的链接
                Socket socket = serverSocket.accept();
                ThreadTest t = new ThreadTest(socket);
                MyThreadFactory myThreadFactory = new MyThreadFactory(" -线程");
                thread = myThreadFactory.newThread(t);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
