package com.myMybatis;

import com.myMybatis.dao.UserMapper;
import com.myMybatis.entity.User;
import com.myMybatis.session.SqlSession;
import com.myMybatis.session.SqlSessionSingleton;

import java.util.Arrays;
import java.util.List;

/**
 * @author: xs
 * @describe:
 * @since 2022/1/20
 */
public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionSingleton.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.selectAllByAge(2);
        for (User user1 : user) {
            System.out.println(user1.toString());
        }


    }


}
