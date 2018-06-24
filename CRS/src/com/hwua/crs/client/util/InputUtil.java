package com.hwua.crs.client.util;

import java.util.Scanner;

/**
 * @Author: yoSakura
 * @Date: 2018/6/12 9:33
 */
public class InputUtil {
    static Scanner input = new Scanner(System.in);
    public static int nextInt () {
        return input.nextInt();
    }

    public static String next () {
        return input.next();
    }

    public static long nextLong () {
        return input.nextLong();
    }

    public static double nextDouble () {
        return input.nextDouble();
    }
}
