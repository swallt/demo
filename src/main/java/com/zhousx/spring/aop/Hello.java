package com.zhousx.spring.aop;

public class Hello implements IHello{
    @Override
    public void sayHello(String str) {
        System.out.println("hello "+str);
    }
}
