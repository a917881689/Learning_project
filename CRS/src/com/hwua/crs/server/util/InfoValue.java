package com.hwua.crs.server.util;

/**
 * @Author: yoSakura
 * @Date: 2018/6/12 10:13
 */
public enum InfoValue {

    /**
     * @DEFAULT 默认参数标识
     * @ACCOUNT_NO_REPEAT 账号信息不重复标识
     * @ACCOUNT_REPEAT 账号信息重复标识
     * @SEX_ERROR 性别设置错误标识
     * @IDENTIFICATION 标识分割符
     * @ACCOUNT_CHECK 账号检查标识
     * @SELECT sql查询标识
     * @UPDATE sql修改语句标识
     * @DOUBLE_UPDATE sql双重修改标识
     * @CAR car对象标识
     * @BRAND brand对象标识
     * @CATEGORY category对象标识
     * @RECORD record对象标识
     * @USER user对象标识
     */
    DEFAULT(0,"未知错误"),ACCOUNT_NO_REPEAT(1304,"账号信息不重复"),ACCOUNT_REPEAT(-1304,"账号信息重复"),
    SEX_ERROR(-1600,"性别设置错误"),IDENTIFICATION(0000,"#16#"), ACCOUNT_CHECK(0003,"ACCOUNT_CHECK"),
    SELECT(0004,"SELECT"),UPDATE(0005,"UPDATE"),DOUBLE_UPDATE(0006,"DOUBLE_UPDATE"),
    CAR(11,"CAR"),BRAND(2,"BRAND"),CATEGORY(2,"CATEGORY"),RECORD(6,"RECORD"),USER(8,"USER"),
    QUERY_RECORD(0,"SELECT id,user_id,car_id,to_char(start_date,'yyyy-mm-dd HH24:mi:ss') AS \"start_date\",to_char(return_date,'yyyy-mm-dd HH24:mi:ss') AS \"return_date\",payment FROM t_record "),
    EXCEL_CAR(123,"EXCEL_CAR");

    private int value;
    private String info;

    /**
     * 构造方法
     * @param
     */
    InfoValue(int value,String info) {
        this.value = value;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return info;
    }

    public static InfoValue getInfoValue (String info) {
        for (InfoValue c : InfoValue.values()) {
            if (c.getInfo().equals(info)) {
                return c;
            }
        }
        return null;
    }
}
