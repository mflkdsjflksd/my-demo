package java.com.设计模式.代理模式.JDK代理;

import com.设计模式.代理模式.JDK代理.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * @Author: xs
 * @describe: 代理对象工厂
 * @date 2022/3/11 12:25
 */
public class ProxyFactory<T> {
    public T getProxyInstance(T target) {
        ProxyHandler handler = new ProxyHandler(target);
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

}
