package com.zhousx.spring.aop;

public class Test {
    public static void main(String[] args) {
        IHello hello = new ProxyHello(new Hello());
        //IHello hello = new Hello();
        hello.sayHello("tommorrow");
    }
}
