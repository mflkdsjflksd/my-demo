package myMybatis.dao;

import myMybatis.entity.User;
import myMybatis.zhujie.MyParam;

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
    User selectOneUser(@MyParam("username") String username);

    /**
     * @Author: xs
     * @Date: 2022/1/20 17:41
     * @describe: 根据年龄查询多个用户
     */
    List<User> selectAllByAge(@MyParam("age") int age);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:15
     * @describe: 通过用户名和年龄查询单个用户
     */
    User selectOneUserByUsernameAndAge(@MyParam("username") String username, @MyParam("age") int age);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:31
     * @describe: 根据id修改用户
     */
    int updateUserById(@MyParam("username")String username,@MyParam("age") int age,@MyParam("id") int id);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:31
     * @describe:
     */
    int insertUser(@MyParam("username")String username, @MyParam("age")int age);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:33
     * @describe: 根据id删除用户
     */
    int deleteUserById(@MyParam("id")int id);

    /**
     * @Author: xs
     * @Date: 2022/3/22 11:54
     * @describe: 批量添加用户
     */
    int batchInsertUser(List list);
}
