package java.com.myMybatis.session;

import java.util.List;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public interface SqlSession {
    /**
     * 根据传入的条件查询单一结果
     *
     * @author: xs
     * @return: 指定结果对象
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 根据传入条件查询多个结果
     *
     * @Author: xs
     * @Return: 指定结果集集合
     */
    <E> List<E> selectList(String statement, Object parameter);

    /**
     * @Author: xs
     * @Date: 2022/1/20 15:26
     * @describe: 获取mapper
     */
    <T> T getMapper(Class<T> type);
    /**
     * @Author: xs
     * @Date: 2022/1/21 22:35
     * @describe: 更新删除插入通用
     */
    int  updateOne(String s, Object args);
}
