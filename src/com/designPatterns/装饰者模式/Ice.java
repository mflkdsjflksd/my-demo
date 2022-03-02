package com.designPatterns.装饰者模式;

/**
 * @Author: xs
 * @describe: 加冰
 * @date 2022/3/2 13:12
 */
public class Ice extends Decorator {
    public Ice(Drink drink) {
        super(drink);
        setDescribe("加冰");
        setPrice(0.5f);
    }
}
