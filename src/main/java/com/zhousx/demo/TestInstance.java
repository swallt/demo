package com.zhousx.demo;

public class TestInstance {
    public static void main(String[] args){
        Person person = new Person("张三"){
            @Override
            public String getName(){
                System.out.println(this.name+"123");
                return this.name;
            }
        };
        System.out.println(person.getName());
        
        Person1 person1 = new Person1() {
            String s = "a";
            {
                System.out.println(s);
            }
            @Override
            public void print() {
                System.out.println(s+"123");
            }
        };
    }
}

class Person{
    String name ;
    static{
        System.out.println("aa");
    }
    public Person(String name){
        this.name = name;
        System.out.println("构造方法执行。。。");
    }
    {
        name = "李四";
        System.out.println("实例初始化代码块。。。");
    }
    public String getName(){
        return this.name;
    }
}

interface Person1{
    void print();
}