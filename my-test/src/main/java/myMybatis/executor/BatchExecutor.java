package myMybatis.executor;

import myMybatis.config.MappedStatement;
import myMybatis.entity.User;
import myMybatis.utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/22 11:41
 */
public class BatchExecutor implements Executor {
    @Override
    public <E> List<E> query(MappedStatement ms, Object[] parameter) {
        return null;
    }

    @Override
    public int update(MappedStatement ms, Object[] parameter) {

        if (parameter[0] instanceof List) {
            List<User> list = (List<User>) parameter[0];
            int res = 0;
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                //获取连接
                connection = DruidUtil.getConnection();
                preparedStatement = connection.prepareStatement(ms.getSql());
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setString(1, list.get(i).getUsername());
                    preparedStatement.setInt(2, list.get(i).getAge());
                    preparedStatement.addBatch();
                    if ((i + 1) % 5000 == 0) {
                        res += Arrays.stream(preparedStatement.executeBatch()).sum();
                        preparedStatement.clearBatch();
                    }
                }
                //请求数据库,并返回结果
                res += Arrays.stream(preparedStatement.executeBatch()).sum();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DruidUtil.close(resultSet, preparedStatement, connection);
            }
            return res;
        }

        return 0;
    }
}
