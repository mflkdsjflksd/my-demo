package com.myMybatis.dao;

import com.myMybatis.entity.User;

import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/1/20 15:49
 */
public interface UserMapper {
    /**
     * @Author: xs
     * @Date: 2022/1/20 15:59
     * @describe: 根据年龄和用户名查找单个用户
     */
    User selectOneUser(String username);
    /**
     * @Author: xs
     * @Date: 2022/1/20 17:41
     * @describe: 根据年龄查询多个用户
     */
    List<User> selectAllByAge(int age);
}
