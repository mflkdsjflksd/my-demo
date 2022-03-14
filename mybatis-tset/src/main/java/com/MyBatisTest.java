package com;

import com.entity.BookTest;
import com.entity.User;
import com.mapper.UserMapper;
import com.plugins.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * XMLScriptBuilder(所系SQL语句)-> DynamicSqlSource处理Sql ForEachSqlNode 处理循环
 * <p>
 * CachingExecutor -> BaseExecutor->doQuery -> query
 * 设置参数类 ParamNameResolver类 getNamedParams方法
 */
public class MyBatisTest {
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

    @Test
    public void test() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1, 2, "1");
    }

    /**
     * @Author: xs
     * @Date: 2022/3/8 21:32
     * @describe: DynamicSqlSource处理参数，sql参数处理断点调试
     */
    @org.junit.Test
    public void test1() {
        session = factory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        User users = mapper.selectByIdSqlTest(1, null, "x", integers);
        System.out.println(users);
    }
    /**
     * @Author: xs
     * @Date: 2022/3/12 13:14
     * @describe: NOGL表达式
     */
    @org.junit.Test
    public void Test2() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        User user = new User().setUsername("1");
        System.out.println(evaluator.evaluateBoolean("username != null", user));
        //通过bookTest.bookName 这种方式，必须要在前面判断bookTest等于空吗
        user.setBookTest(new BookTest());
        user.getBookTest().setBookName("测试");
        System.out.println(evaluator.evaluateBoolean("bookTest.bookName != null", user));
    }

    @Test
    public void testPage() {
        session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.pageTest(new Page(1, 10));
        System.out.println(users);
    }
}

