package com.设计模式.代理模式.Cglib;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/9 11:10
 */
public class HelloWorldCglib {

    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }

    public String handle(String str) {
        return str + "Test";
    }
}
