package java.com.设计模式.装饰者模式;


/**
 * @Author: xs
 * @describe: 装饰者模式测试类
 * @date 2022/3/2 13:15
 */
public class Test {
    public static void main(String[] args) {
        Drink order = new Coca();
        order = new Ice(order);
        order = new Sugar(order);
        System.out.println(order.cost() + order.getDescribe());
    }
}
