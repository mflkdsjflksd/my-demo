package com.designPatterns.decorated;

/**
 * @Author: xs
 * @describe: 加糖
 * @date 2022/3/2 13:13
 */
public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        setDescribe("加糖");
        setPrice(2.0f);
    }
}
