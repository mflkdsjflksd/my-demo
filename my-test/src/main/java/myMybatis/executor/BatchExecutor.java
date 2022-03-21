package myMybatis.executor;

import myMybatis.session.SqlSession;

import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/21 21:05
 */
public class BatchExecutor implements SqlSession {
    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return null;
    }

    @Override
    public int updateOne(String s, Object args) {
        return 0;
    }
}
