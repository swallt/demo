package com.zhousx.spring.aop;

public class ProxyHello implements IHello{
    private IHello iHello;
    public ProxyHello(IHello hello){
        super();
        this.iHello = hello;
    }

    @Override
    public void sayHello(String str) {
        Logger.start();
        iHello.sayHello(str);
        Logger.end();
    }
}
