package java.com.设计模式.装饰者模式;

import com.设计模式.装饰者模式.Coffee;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/2 13:04
 */
public class Coca extends Coffee {
    public Coca() {
        setDescribe("可乐");
        setPrice(3.0f);
    }
}
