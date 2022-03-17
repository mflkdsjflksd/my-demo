package java.com.设计模式.工厂模式.简单工厂模式;

import com.设计模式.工厂模式.简单工厂模式.Pizza;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 15:15
 */
public class Greek implements Pizza {
    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Greek{" +
                "name='" + name + '\'' +
                '}';
    }
}
