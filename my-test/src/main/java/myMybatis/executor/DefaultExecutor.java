package myMybatis.executor;

import myMybatis.config.MappedStatement;
import myMybatis.utils.DruidUtil;
import myMybatis.utils.ResultUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xs
 * @describe: 默认执行器
 * @date 2022/1/20 15:19
 */
public class DefaultExecutor implements Executor {

    @Override
    public <E> List<E> query(MappedStatement ms, Object[] parameter) {
        List<E> ret = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = DruidUtil.getConnection();
            preparedStatement = connection.prepareStatement(ms.getSql());

            ResultUtil.parameterize(ms, preparedStatement, parameter);
            //请求数据库
            resultSet = preparedStatement.executeQuery();
            //处理结果集
            ResultUtil.handlerResultSet(resultSet, ret, ms.getResultType());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtil.close(resultSet, preparedStatement, connection);
        }
        return ret;
    }

    @Override
    public int update(MappedStatement ms, Object[] parameter) {
        int res = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = DruidUtil.getConnection();
            //处理参数
            preparedStatement = connection.prepareStatement(ms.getSql());
            //处理传进来的参数
            ResultUtil.parameterize(ms, preparedStatement, parameter);
            //请求数据库,并返回结果
            res = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtil.close(resultSet, preparedStatement, connection);
        }
        return res;
    }
}
