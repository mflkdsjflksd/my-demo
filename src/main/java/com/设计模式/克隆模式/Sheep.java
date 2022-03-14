package com.设计模式.克隆模式;

import lombok.Data;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/11 16:02
 */
@Data
public class Sheep implements Cloneable {
    String name;
    int age;
    Sheep friend;

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        Sheep clone = (Sheep) super.clone();
        return clone;
    }

}
