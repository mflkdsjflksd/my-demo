package com.设计模式.代理模式.静态代理;

/**
 * @Author: xs
 * @describe:老师徐
 * @date 2022/3/9 0:05
 */
public class TeacherProxy implements Proxy {
    private TeacherLi target;

    @Override
    public void speak() {
        target.speak();
    }

    public TeacherProxy(TeacherLi target) {
        this.target = target;
    }
}
