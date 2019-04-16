package com.zhousx.demo;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    public String toString(Object obj){
        Class cl = obj.getClass();

        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Object val = f.get(obj);
                        r += toString(val);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                r+= "]";
                cl = cl.getSuperclass();
            }
        } while (cl != null);
            return r;
    }
    public static void main(String[] args){
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i =1; i<= 5; i++) squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
