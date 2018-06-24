package com.hwua.crs.server.util;

import java.util.concurrent.ThreadFactory;

/**
 * @Author: yoSakura
 * @Date: 2018/5/31 17:39
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter;
    private String name;

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable run) {
        Thread t = new Thread(run, name + "-Thread-" + counter);
        counter++;
        return t;
    }
}
