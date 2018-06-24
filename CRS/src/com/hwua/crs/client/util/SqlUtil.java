package com.hwua.crs.client.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlUtil {
    private static String identification(String sql) {
        return ""+InfoValue.IDENTIFICATION+sql+InfoValue.IDENTIFICATION;
    }
    public static String querySql (String sql,InfoValue info) {
        return ""+InfoValue.SELECT+identification(sql)+info;
    }
    public static String updateSql (String sql,InfoValue info) {
        return  ""+InfoValue.UPDATE+identification(sql)+info;
    }
    public static String userCheckSql (String sql) {
        return ""+InfoValue.ACCOUNT_CHECK+identification(sql)+InfoValue.USER;
    }
    public static String doubleUpdate (String sql, InfoValue info, String sql2, InfoValue info2) {
        return ""+InfoValue.DOUBLE_UPDATE+identification(sql)+info+identification(sql2)+info2;
    }
    public static String excelUpdate (String sql) {
        return ""+InfoValue.EXCEL_CAR+identification(sql)+InfoValue.CAR;
    }
    public static Timestamp strToSqlDate(String strDate) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        if (strDate == null) {
            return null;
        }
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        return dateSQL;
    }
    public static String getTime() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
    }
    public static Timestamp getTimestamp () {
        return new Timestamp(System.currentTimeMillis());
    }
    public static void close (Connection conn, Statement stmt, ResultSet result) {
        try {
            if (result != null) {result.close();}
            if (stmt != null) {stmt.close();}
            if (conn != null) {conn.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close (Socket socket, PrintWriter pw, BufferedReader br) {
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
