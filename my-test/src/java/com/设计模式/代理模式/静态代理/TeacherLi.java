package java.com.设计模式.代理模式.静态代理;

/**
 * @Author: xs
 * @describe: 老师李
 * @date 2022/3/9 0:04
 */
public class TeacherLi implements Proxy{
    @Override
    public void speak() {
        System.out.println("李老师授课中。。。。。。。。。");
    }
}
