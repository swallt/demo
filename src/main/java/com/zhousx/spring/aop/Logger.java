package com.zhousx.spring.aop;

import java.util.Date;

public final class Logger {
    public static void start(){
        System.out.println(new Date() + " sya hello start...");
    }

    public static void end(){
        System.out.println(new Date() + " say hello end");
    }
}
