package com.zhuokun.HelloWorld;

public class HelloWorld {

    // No constructor defined, use empty constructor by default
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public void printHello(){
        System.out.println("The first SPRING: HELLO "+this.name);
    }
}
