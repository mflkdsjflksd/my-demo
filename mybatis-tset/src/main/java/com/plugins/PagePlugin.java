package com.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: xs
 * @describe: 拦截器插件
 * @date 2022/3/10 21:11
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class PagePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler target = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = target.getBoundSql();
        Object parameterObject = boundSql.getParameterObject();
        Page page = null;
        if (parameterObject instanceof Page) {
            page = (Page) parameterObject;
        } else if (parameterObject instanceof Map) {
            Map map = (Map) parameterObject;
            for (Object k : map.keySet()) {
                if (k instanceof Page) {
                    page = (Page) k;
                    break;
                }
            }
        }
        /**
         * @describe: 没有分页信息不处理
         */
        if (page == null) {
            return invocation.proceed();
        }
        /**
         * @describe: 分页执行逻辑
         */
        page.setTotal(selectCount(invocation));
        StringBuilder newSql = new StringBuilder(boundSql.getSql());
        newSql.append(" limit ").append(page.getOffset()).append(" , ").append(page.getSize() == 0 ? 10 : page.getSize());
        SystemMetaObject.forObject(boundSql).setValue("sql", newSql.toString());
        return invocation.proceed();
    }

    /**
     * @Author: xs
     * @Date: 2022/3/10 22:08
     * @describe: 执行查找分页
     */
    private int selectCount(Invocation invocation) throws SQLException {
        int count = 0;
        StatementHandler target = (StatementHandler) invocation.getTarget();
        String countSql = String.format("select count(0)  from (%s) as page", target.getBoundSql().getSql());
        //JDBC
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement preparedStatement = connection.prepareStatement(countSql);
        //通过参数处理器处理参数
        target.getParameterHandler().setParameters(preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        resultSet.close();
        preparedStatement.close();
        return count;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
