package com.设计模式.单例模式;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/11 13:21
 */
public class DoubleCheck {
    private static DoubleCheck doubleCheck;

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheck.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }

    public void test() {
        System.out.println("DoubleCheck");
    }
}
