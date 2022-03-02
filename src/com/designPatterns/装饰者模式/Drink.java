package com.designPatterns.装饰者模式;

/**
 * @Author: xs
 * @describe: 饮料统一接口
 * @date 2022/3/2 13:01
 */
public abstract class Drink {
    private String describe;
    private float price;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    /**
     * @Author: xs
     * @Date: 2022/3/2 13:03
     * @describe: 计算饮品费用
     */
    public abstract float cost();
}
