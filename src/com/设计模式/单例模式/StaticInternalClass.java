package com.设计模式.单例模式;

/**
 * @Author: xs
 * @describe: 静态内部类
 * @date 2022/3/11 13:25
 */
public class StaticInternalClass {

    private StaticInternalClass() {
    }

    public static StaticInternalClass getStaticInternalClass() {
        return InternalClass.staticInternalClass;
    }

    private static class InternalClass {
        private static StaticInternalClass staticInternalClass = new StaticInternalClass();
    }

    public void test() {
        System.out.println("StaticInternalClass");
    }

}
