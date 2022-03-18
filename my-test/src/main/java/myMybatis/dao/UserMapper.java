package myMybatis.dao;

import myMybatis.entity.User;
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

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:15
     * @describe: 通过用户名和年龄查询单个用户
     */
    User selectOneUserByUsernameAndAge(String username, int age);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:31
     * @describe: 根据id修改用户
     */
    int updateUserById(String username, int age, int id);

    /**
     * @Author: xs
     * @Date: 2022/1/21 22:31
     * @describe:
     */
    int insertUser(String username, int age);
    /**
     * @Author: xs
     * @Date: 2022/1/21 22:33
     * @describe: 根据id删除用户
     */
    int deleteUserById(int id);
}
