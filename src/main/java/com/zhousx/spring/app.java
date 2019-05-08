package com.zhousx.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext app = new FileSystemXmlApplicationContext("file:D:\\Users\\zhoushx\\demo\\src\\main\\resources\\applicationContext.xml");

     /*   FruitPlate fp1 = (FruitPlate) app.getBean("fruitPlate1");
        FruitPlate fp2 = (FruitPlate) app.getBean("fruitPlate2");

        fp1.getFreit();
        fp2.getFreit();*/
        LookupMethodBean lookupMethodBean = (LookupMethodBean) app.getBean("lookupMethodBean");
        lookupMethodBean.test();

        LookupMethodBean replace = (LookupMethodBean) app.getBean("testBean");
        replace.test();
    }
}
