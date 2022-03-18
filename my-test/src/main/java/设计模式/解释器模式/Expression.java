package 设计模式.解释器模式;

import java.util.HashMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:14
 */
public abstract class Expression {
    public abstract int interpreter(HashMap<Character, Integer> var);
}
