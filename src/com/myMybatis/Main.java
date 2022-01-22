package com.myMybatis;

import com.myMybatis.dao.UserMapper;
import com.myMybatis.entity.User;
import com.myMybatis.session.SqlSession;
import com.myMybatis.session.SqlSessionFactory;


import java.util.List;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
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
        userMapper.updateUserById("xushan", 1, 1);
        System.out.println();
    }
}

