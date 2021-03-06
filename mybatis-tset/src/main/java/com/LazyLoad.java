package com;

import com.entity.BookTest;
import com.entity.User;
import com.mapper.UserMapper;
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
 * @describe:
 * @date 2022/3/8 0:27
 * JavassistProxyFactory->EnhancedResultObjectProxyImpl
 */
public class LazyLoad {
    SqlSessionFactory factory;
    String resource = "mybatis-config.xml";
    Reader reader;
    SqlSession session;

    @Before
    public void init() throws IOException {
        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
    }

    @After
    public void close() {
        session.close();
    }

    /**
     * @Author: xs
     * @Date: 2022/3/8 0:39
     * @describe: 懒加载测试
     */
    @Test
    public void test1() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectByIdTest(1);
        System.out.println(users);
    }

}
