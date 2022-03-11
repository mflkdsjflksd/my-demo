package com.设计模式.解释器模式;

import java.util.HashMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:20
 */
public class SymbolExpression extends Expression {
    Expression left;
    Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<Character, Integer> var) {
        return 0;
    }
}
