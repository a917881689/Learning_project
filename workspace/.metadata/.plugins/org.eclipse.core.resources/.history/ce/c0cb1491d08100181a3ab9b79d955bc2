package com.hwua.crs.server.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public static String doubleUpdate (String sql,InfoValue info,String sql2,InfoValue info2) {
        return ""+InfoValue.DOUBLE_UPDATE+identification(sql)+info+identification(sql2)+info2;
    }
    public static Object[] transformation(Object obj,InfoValue infoValue) {
        String json = null;
        if (obj != null) {
            json = JSON.toJSONString(obj,SerializerFeature.WriteMapNullValue);
        }
        Object [] objArray = null;
        boolean flag = false;
        if (json == null) {
            flag = true;
        }
        if (!flag) {
            json = json.replace("\"","");
            json = json.replace("{","");
            json = json.replace("}","");
            String[] str = json.split(",");

            objArray = new Object[infoValue.getValue()];
            switch (infoValue) {
                case RECORD:
                    for (int i = 0;i < infoValue.getValue();i++) {
                        String[] strInfo = str[i].split(":");
                        if (!"-1".equals(strInfo[1]) && !"null".equals(strInfo[1]) && !"-1.0".equals(strInfo[1]) ) {
                            objArray[i] = strInfo[1];
                            if("a".equals(strInfo[0]) || "b".equals(strInfo[0])) {
                                objArray[i] = str[i].substring(2,str[i].length());
                            }
                        }else {
                            objArray[i] = null;
                        }
                    }
                    break;
                default:
                    for (int i = 0;i < infoValue.getValue();i++) {
                        String[] strInfo = str[i].split(":");
                        if (!"-1".equals(strInfo[1]) && !"null".equals(strInfo[1]) && !"-1.0".equals(strInfo[1]) ) {
                            objArray[i] = strInfo[1];
                        }else {
                            objArray[i] = null;
                        }
                    }
            }

        }
        return objArray;
    }
    public static java.sql.Timestamp strToSqlDate(String strDate) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date date = null;
        if (strDate == null) {
            return null;
        }
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        return dateSQL;
    }
    public static String getTime() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
    }
    public static Timestamp getTimestamp () {
        return new Timestamp(System.currentTimeMillis());
    }
}
