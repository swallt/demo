package com.zhousx.demo;

import io.netty.channel.SimpleChannelInboundHandler;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {
    public static void main(String[] args) throws Exception{
        ExecutorService pool = Executors.newCachedThreadPool();
        ArrayList<Callable<Void>> runners = new ArrayList<>();
        for (int i=0;i<10;i++){
            runners.add(()->{
                Single.getInstance("as");
                return null;
            });
        }
        System.out.println("启动线程");
        pool.invokeAll(runners);
        pool.shutdown();
        System.in.read();
    }
}

class Single{
    private static Single instance;
    public Single(String context){
        System.out.println("创建单例");
    }
    public static Single getInstance(String context){
        if (instance == null){
            {
                synchronized (Single.class){
                    if (instance == null){
                        instance = new Single(context);
                    }
                }
            }
//            instance = new Single(context);
        }
        return instance;
    }
}