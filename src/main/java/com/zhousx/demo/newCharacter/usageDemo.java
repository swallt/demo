package com.zhousx.demo.newCharacter;

public class usageDemo {

    public static void main(String[] args) {
        //static methods
        IConvert<String,String> convert = something::startsWith;
        String converted = convert.convert("123");
        System.out.println(converted);

        //object methods
        something something = new something();
        IConvert<String,String> convert1 = something::endWith;
        String str = convert1.convert("java");
        System.out.println(str);

        //constructor methods
        IConvert<String,something> convert2 = something::new;
        something something1 = convert2.convert("constructors");
    }
}
