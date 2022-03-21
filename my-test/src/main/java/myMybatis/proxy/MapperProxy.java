package myMybatis.proxy;


import myMybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @Author: xs
 * @describe: 动态代理解析接口
 * @date 2022/1/20 16:03
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession session;

    public MapperProxy(SqlSession session) {
        this.session = session;
    }


    /**
     * @Author: xs
     * @Date: 2022/1/21 22:08
     * @describe: jdk代理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        if (Collection.class.isAssignableFrom(returnType)) {
            return session.selectList(method.getDeclaringClass().getName() + "." + method.getName(), args);
        } else if (int.class.isAssignableFrom(returnType)) {
            return session.updateOne(method.getDeclaringClass().getName() + "." + method.getName(), args);
        } else {
            return session.selectOne(method.getDeclaringClass().getName() + "." + method.getName(), args);
        }
    }
}
