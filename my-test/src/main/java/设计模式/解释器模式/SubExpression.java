package 设计模式.解释器模式;


import java.util.HashMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:27
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<Character, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
