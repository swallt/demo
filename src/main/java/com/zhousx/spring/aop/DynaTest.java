package com.zhousx.spring.aop;

import org.springframework.core.Ordered;

public class DynaTest {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
        hello.sayHello("tommorrow");
    }
}

