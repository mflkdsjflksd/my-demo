package java.com.设计模式.工厂模式.简单工厂模式;

import com.设计模式.工厂模式.简单工厂模式.Pizza;
import com.设计模式.工厂模式.简单工厂模式.SimpleFactory;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 15:05
 */
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new SimpleFactory().create("希腊披萨");
        System.out.println(pizza);
    }
}
