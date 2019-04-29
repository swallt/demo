package com.zhousx.demo.concurrent;

/**
 * java指令重排序问题
 * 有两个共享变量：a和flag，初始值分别为0和false，在ThreadA中先给a=1，然后flag=true；
 * 如果有序的化，那么ThreadB中如果if（flag）成功的化，贼应该a=1，而a=a*1之后仍为1，下方的if（a==0）应该永远不会执行
 */
public class SimpleHappenBefore {
    private static int a;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0;i<100;i++){
            ThreadA threadA = new ThreadA();
            ThreadB threadB = new ThreadB();
            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
            a=0;
            flag = false;
        }
    }

    private static class ThreadA extends Thread{
        public void run(){
            a=1;
            flag=true;
        }
    }

    private static class ThreadB extends Thread{
        public void run(){
            if (flag){
                a=a*1;
            }
            if (a==0){
                System.out.println("error,a == 0");
            }
        }
    }
}
