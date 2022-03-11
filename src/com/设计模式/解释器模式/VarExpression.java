package com.设计模式.解释器模式;

import java.util.HashMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:16
 */
public class VarExpression extends Expression{
    private Character key;

    public VarExpression(Character key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<Character, Integer> var) {
        return var.get(this.key);
    }
}
