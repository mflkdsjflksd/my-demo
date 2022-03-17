package java.com.设计模式.装饰者模式;

import com.设计模式.装饰者模式.Decorator;
import com.设计模式.装饰者模式.Drink;

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
