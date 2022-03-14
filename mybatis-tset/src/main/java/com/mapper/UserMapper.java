package com.mapper;

import com.entity.User;
import com.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    User selectById(@Param("id") Integer id, @Param("age") Integer age, @Param("username") String username);

    User selectByIdSqlTest(@Param("id") Integer id, @Param("age") Integer age, @Param("username") String username, @Param("list") List list);

    @Select("select * from user where  age = 1")
    List<User> pageTest(Page page);
}
