package myMybatis;

import myMybatis.dao.UserMapper;
import myMybatis.enumType.ExecutorType;
import myMybatis.session.SqlSession;
import myMybatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public class Main {
    SqlSession sqlSession;
    UserMapper userMapper;

    public static void main(String[] args) {

/*        SqlSession sqlSession = SqlSessionFactory.getSqlSession(ExecutorType.DEFAULT_EXECUTOR);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //测试插入count条数据量耗时
        long start = System.currentTimeMillis();
        int count = 100000;
        for (int i = 0; i < 100000; i++) {
            userMapper.insertUser(String.valueOf(i), i);
        }
        long end = System.currentTimeMillis();
        //结果129391
        System.out.println("测试插入" + count + "条数据耗时：" + (end -start ));

        //测试删除count条数据耗时
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            userMapper.deleteUserById(i);
        }
        end = System.currentTimeMillis();
        //结果129391
        System.out.println("测试插入" + count + "条数据耗时：" + (end -start ));*/
        /**
         * @describe: 使用批处理器插入一百万条数据
         */
//        SqlSession sqlSession = SqlSessionFactory.getSqlSession(ExecutorType.BATCH_EXECUTOR);
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //测试插入count条数据量耗时
//        long start = System.currentTimeMillis();
//        int count = 1000000;
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            users.add(new User(String.valueOf(i), i));
//        }
//        userMapper.batchInsertUser(users);
//        long end = System.currentTimeMillis();
//        //结果1744
//        System.out.println("测试插入" + count + "条数据耗时：" + (end - start));
    }

    @Before
    public void init() {
        sqlSession = SqlSessionFactory.getSqlSession(ExecutorType.DEFAULT_EXECUTOR);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test() {
        try {
            userMapper.insertUser("1", 1);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    @Test
    public void test2() {
        userMapper.insertUser("1", 1);
    }
}

