package com.designPatterns.解释器模式;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:31
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();
        char[] chars = expStr.toCharArray();
        Expression left;
        Expression right;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                left = stack.pop();
                right = new VarExpression(chars[++i]);
                stack.push(new AddExpression(left, right));
            } else if (chars[i] == '-') {
                left = stack.pop();
                right = new VarExpression(chars[++i]);
                stack.push(new SubExpression(left, right));
            } else {
                stack.push(new VarExpression(chars[i]));
            }
        }
        this.expression = stack.pop();

    }

    public int run(HashMap<Character, Integer> var) {
        return this.expression.interpreter(var);
    }
}
