package 设计模式.工厂模式.简单工厂模式;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 15:17
 */
public class Cheese implements Pizza {
    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                '}';
    }
}
