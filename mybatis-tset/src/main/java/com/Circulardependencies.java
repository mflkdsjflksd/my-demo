package com;

import com.entity.BookTest;
import com.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @Author: xs
 * @describe: 嵌套查询解决依赖冲突的问题
 * @date 2022/3/7 15:47
 */
public class Circulardependencies {
    SqlSessionFactory factory;
    String resource;
    Reader reader;
    SqlSession session;

    @Before
    public void init() throws IOException {
        resource = "mybatis-config.xml";
        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession(true);
    }

    @After
    public void close() {
        session.close();
    }

    /**
     * @Author: xs
     * @Date: 2022/3/8 0:28
     * @describe: 循环依赖
     */
    @Test
    public void test() {
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<BookTest> book = mapper.selectBookById(1);
        System.out.println(book);
    }
}
