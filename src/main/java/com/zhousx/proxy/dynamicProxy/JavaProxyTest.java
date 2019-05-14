package com.zhousx.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("restriction")
public class JavaProxyTest {
    public static void main(String[] args) {
        JavaProxyInterface javaProxyInterface = new ConcreteClass();
        JavaProxyInterface newProxy = (JavaProxyInterface) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(),
                new Class[]{JavaProxyInterface.class}, new MyInvocationHandler(javaProxyInterface));
        newProxy.gotoSchool();
        newProxy.gotoWork();
        //声明final的方法，jdk代理aopMethod只执行1次
        newProxy.oneDay();
        newProxy.oneDayFinal();
    }
}

class MyInvocationHandler implements InvocationHandler{
    JavaProxyInterface javaProxyInterface;
    public MyInvocationHandler(JavaProxyInterface javaProxyInterface){
        this.javaProxyInterface = javaProxyInterface;
    }
    private void aopMethod(){
        System.out.println("before method...");
    }

    //继承方法，代理时实际执行的方法，如果要实现原方法，则需要调用method.invoke(javaProxy,args)，
    //调用aopMethod，类比于spring中的切面before注解
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aopMethod();
        return method.invoke(javaProxyInterface,args);
    }
}

/**
 * 需要被代理的类，实现顶层接口
 */
class ConcreteClass implements JavaProxyInterface{

    @Override
    public void gotoSchool() {
        System.out.println("go to school..");
    }

    @Override
    public void gotoWork() {
        System.out.println("go to work..");
    }

    @Override
    public void oneDay() {
        gotoSchool();
        gotoWork();
    }

    @Override
    public final void oneDayFinal() {
        gotoSchool();
        gotoWork();
    }
}

/**
 * 顶层接口
 */
interface JavaProxyInterface{
    void gotoSchool();
    void gotoWork();
    void oneDay();
    void oneDayFinal();
}