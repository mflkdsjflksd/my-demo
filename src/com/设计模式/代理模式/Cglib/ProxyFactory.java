package com.设计模式.代理模式.Cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: xs
 * @describe: 代理工厂
 * @date 2022/3/11 14:40
 */
public class ProxyFactory<T> implements MethodInterceptor {
    T target;

    public ProxyFactory(T target) {
        this.target = target;
    }

    public T getTarget() {
        //1.创建工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象(代理对象)
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object args0, Method method, Object[] args1, MethodProxy args2) throws Throwable {
        System.out.println("Cglib代理模式开始");
        Object invoke = method.invoke(target, args1);
        System.out.println("Cglib代理模式结束");
        return invoke;
    }
}
