package com.zhousx.spring;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MethodReplace implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("方法已被替换");
        return null;
    }
}
