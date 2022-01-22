package com.myMybatis.executor;

import com.myMybatis.MappedStatement;

import java.util.List;

/**
 * @Author: xs
 * @describe: 执行sql
 */
public interface Executor {
    /**
     * @Author: xs
     * @Date: 2022/1/20 15:21
     * @describe:
     */
    <E> List<E> query(MappedStatement ms, Object parameter);

    int update(MappedStatement ms, Object parameter);
}
