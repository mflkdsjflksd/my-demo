package com.designPatterns.代理模式.JDK代理;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/9 11:10
 */
public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        ProxyFactory<Hello> proxyFactory = new ProxyFactory();
        Hello proxyClass = proxyFactory.getProxyInstance(helloWorld);
        proxyClass.morning("李老师");
        System.out.println(proxyClass.handle("proxy"));
        System.out.println(proxyClass.getClass());
    }
}

