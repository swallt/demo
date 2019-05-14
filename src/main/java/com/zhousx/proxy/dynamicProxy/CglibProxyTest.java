package com.zhousx.proxy.dynamicProxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 静态代理  简单，代理模式，是动态代理的理论基础。常见使用在代理模式
 * jdk      需要有顶层接口才能使用，只有顶层接口的时候也可以使用（mybatis的mapper文件代理），
 *          使用反射完成，使用动态生成字节码技术
 * cglib    可以直接使用代理类，使用字节码技术，不能对final类进行继承。使用了动态生成字节码技术
 *
 * spring中，如果类有顶层接口，则默认使用jdk的动态代理来代理，如果直接是一个类，则使用cglib动态代理。
 * 其次，如果没有需要代理的方法，如所有方法都没有@Transactional注解，Aop这种，则不会被代理
 */
public class CglibProxyTest {
    public static void main(String[] args) throws Exception{
        CglibTestSon cglibTestSon = new CglibTestSon();
        Enhancer enhancer = new Enhancer();
        Callback s = new MyInvoker(cglibTestSon);
        enhancer.setSuperclass(CglibTestSon.class);
        Callback callback[] = new Callback[]{s};
        enhancer.setCallbacks(callback);
        CglibTestSon cglibTestSon1 = (CglibTestSon) enhancer.create();
        cglibTestSon1.gotohome();
        cglibTestSon1.gotoschool();
        //声明final的方法，cglib代理每次执行都会执行aopMethod方法
        cglibTestSon1.oneday();
        cglibTestSon1.onedayFinal();
    }
}

/**
 * 被代理的类，不需要实现顶层接口
 */
class CglibTestSon{
    public CglibTestSon(){}

    public void gotoschool(){
        System.out.println("cglib go to school...");
    }

    public void gotohome(){
        System.out.println("cglib go to home...");
    }

    public void oneday(){
        gotoschool();
        gotohome();
    }

    public final void onedayFinal(){
        gotoschool();
        gotohome();
    }
}

class MyInvoker implements MethodInterceptor{
    private CglibTestSon cglibTestSon;
    public MyInvoker(CglibTestSon cglibTestSon){
        this.cglibTestSon = cglibTestSon;
    }
    private void aopMethod(){
        System.out.println("cglib before aop...");
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        aopMethod();
        return method.invoke(cglibTestSon,objects);
    }
}