package com.test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/1/21 17:12
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.test.Test");
        System.out.println(aClass);
    }
}
