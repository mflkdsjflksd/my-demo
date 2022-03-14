package com.设计模式.代理模式.Cglib;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/11 15:02
 */
public class Main {
    public static void main(String[] args) {
        HelloWorldCglib target = new HelloWorldCglib();
        HelloWorldCglib target1 = new ProxyFactory<>(target).getTarget();
        System.out.println(target1.handle("Cglib"));
        target1.morning("Cglib");
    }
}
