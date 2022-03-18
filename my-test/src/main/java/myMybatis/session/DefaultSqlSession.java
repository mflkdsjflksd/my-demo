package myMybatis.session;

import myMybatis.config.Configuration;
import myMybatis.executor.DefaultExecutor;
import myMybatis.executor.Executor;
import myMybatis.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public class DefaultSqlSession implements SqlSession {
    private final Configuration conf;
    private final Executor executor;

    public DefaultSqlSession(Configuration conf) {
        this.conf = conf;
        executor = new DefaultExecutor(conf);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<Object> selectList = selectList(statement, parameter);
        if (selectList.size() == 1) {
            return (T) selectList.get(0);
        } else if (selectList.size() == 0 || selectList == null) {
            return null;
        } else {
            throw new RuntimeException("Too Many Results");
        }
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return executor.query(conf.getMappedStatements().get(statement), parameter);
    }

    @Override
    public int updateOne(String statement, Object args) {
        return executor.update(conf.getMappedStatements().get(statement), args);
    }

    /**
     * @Author: xs
     * @Date: 2022/1/20 16:19
     * @describe: 动态代理获取类的信息(容器里面的key)
     */
    @Override
    public <T> T getMapper(Class<T> type) {
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, mapperProxy);
    }
}
