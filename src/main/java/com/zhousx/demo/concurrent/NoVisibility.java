package com.zhousx.demo.concurrent;

public class NoVisibility {
    private static boolean ready;
    private static int number;
    /**
     * java内存模型要求，变量的读取操作和写入操作都必须是原子操作，但对于非volatile类型的long和double变量，jvm允许将64位的读操作或写操作分解位两个32位的操作。
     * 多线程环境下，很可能会读取到某个值的高32位和另一个值的低32位。多线程环境下，需要用volatile来声明或者用锁保护起来。
     */
    private static volatile long safalong;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        new ReaderThread().run();
        number = 42;
        ready = true;
    }
}
