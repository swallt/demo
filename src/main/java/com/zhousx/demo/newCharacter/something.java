package com.zhousx.demo.newCharacter;

public class something {

    something(){}

    something(String str){
        System.out.println(str);
    }

    static String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s){
        return String.valueOf(s.charAt(s.length()-1));
    }
    void endWith(){}
}
