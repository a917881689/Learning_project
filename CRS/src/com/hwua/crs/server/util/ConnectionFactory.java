package com.hwua.crs.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        Properties prop = new Properties();
        try {
            prop.load(ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
    public static Connection getConnection () {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
    public static void close (Statement stmt) {
        close(null,stmt,null);
    }
    public static void close (Connection conn) {
        close(conn,null,null);
    }
    public static void close (Connection conn, Statement stmt) {
        close(conn,stmt,null);
    }
    public static void close (Connection conn, Statement stmt,ResultSet result) {
        try {
            if (result != null) {result.close();}
            if (stmt != null) {stmt.close();}
            if (conn != null) {conn.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close (Socket socket,PrintWriter pw,BufferedReader br) {
        try {
            if (br != null) {br.close();}
            if (pw != null) {pw.close();}
            if (socket != null) {socket.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void close (PrintWriter pw,BufferedReader br) {
        close(null,pw,br);
    }
}
