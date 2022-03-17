package java.com.设计模式.代理模式.JDK代理;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/9 11:10
 */
public class HelloWorld implements Hello {
    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }

    @Override
    public String handle(String str) {
        return str + "Test";
    }
}
