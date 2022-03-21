package myMybatis;

import myMybatis.dao.UserMapper;
import myMybatis.enumType.ExecutorType;
import myMybatis.session.SqlSession;
import myMybatis.session.SqlSessionFactory;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactory.getSqlSession(ExecutorType.DEFAULT_EXECUTOR);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //测试插入一百万条数据量耗时

        /*List<User> user = userMapper.selectAllByAge(2);
        //测试方法
        User xs = userMapper.selectOneUser("xushan1");
        for (User user1 : user) {
            System.out.println(user1.toString());
        }
        System.out.println(xs.toString());
        User xs1 = userMapper.selectOneUserByUsernameAndAge("xushan1", 1);
        System.out.println(xs1.toString());
        int i = userMapper.deleteUserById(1);
        System.out.println(i);
        int a = userMapper.insertUser("大帅比", 1);*/
        System.out.println(userMapper.updateUserById("xushan", 2, 1));
    }
}

