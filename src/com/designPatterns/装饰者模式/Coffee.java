package com.designPatterns.装饰者模式;

/**
 * @Author: xs
 * @describe: 咖啡类
 * @date 2022/3/2 13:06
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
