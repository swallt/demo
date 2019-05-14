package com.zhousx.proxy.staticProxy;

/**
 * 静态代理
 */
public class StaticProxy {
    public static void main(String[] args) {
        Singer singer = new Agent(new Star());
        singer.sing();
    }
}

/**
 * 代理实现
 */
class Agent implements Singer{
    Star s;
    public Agent(Star s){
        this.s = s;
    }

    @Override
    public void sing() {
        System.out.println("代理实现...");
        s.sing();
    }
}

/**
 * 真实实现
 */
class Star implements Singer{

    @Override
    public void sing() {
        System.out.println("star sing....");
    }
}
/**
 * 最顶层接口
 */
interface Singer{
    void sing();
}
