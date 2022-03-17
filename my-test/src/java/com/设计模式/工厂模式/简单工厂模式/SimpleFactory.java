package java.com.设计模式.工厂模式.简单工厂模式;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 15:05
 */
public class SimpleFactory {
    public static final String CHEESE = "奶酪披萨";
    public static final String GREEK = "希腊披萨";


    public Pizza create(String type) {
        Pizza pizza = null;
        if (CHEESE.equals(type)) {
            pizza = new Greek();
            pizza.setName(CHEESE);
        } else if (GREEK.equals(type)) {
            pizza = new Cheese();
            pizza.setName(GREEK);
        }
        return pizza;
    }
}
