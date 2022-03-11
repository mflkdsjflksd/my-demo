package com.designPatterns.代理模式.静态代理;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/9 0:04
 */
public class Client {
    public static void main(String[] args) {

        Integer a =1;
        TeacherProxy teacherProxy = new TeacherProxy(new TeacherLi());
        teacherProxy.speak();
    }
}
