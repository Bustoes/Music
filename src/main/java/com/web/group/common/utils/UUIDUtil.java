package com.web.group.common.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("32位UUID ：" + UUIDUtil.getUUID());
    }
}