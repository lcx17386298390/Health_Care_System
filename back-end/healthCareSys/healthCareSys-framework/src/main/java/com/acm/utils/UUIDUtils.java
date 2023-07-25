package com.acm.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String createUUIDStr(){
        return UUID.randomUUID().toString();
    }
}
