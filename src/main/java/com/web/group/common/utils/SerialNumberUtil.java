package com.web.group.common.utils;

public class SerialNumberUtil {

    /**
     * 生成订单号
     */
    public static String genOrderNo() {
        return SerialNumber.createSysSerial("QY", 9);
    }

    /**
     * 生成提货码
     * @return
     */
    public static String genPickNo() {
        return SerialNumber.createSerial( 10);
    }
}
