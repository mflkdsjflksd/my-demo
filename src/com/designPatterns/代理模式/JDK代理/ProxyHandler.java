package com.designPatterns.代理模式.JDK代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/11 12:27
 */
public class ProxyHandler<T> implements InvocationHandler {
    T target;

    public ProxyHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
