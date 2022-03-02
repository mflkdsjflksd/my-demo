package com.designPatterns.装饰者模式;

/**
 * @Author: xs
 * @describe: 装饰者类
 * @date 2022/3/2 13:10
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDescribe() {
        return super.getDescribe() + getPrice() + " && " + drink.getDescribe();
    }
}
