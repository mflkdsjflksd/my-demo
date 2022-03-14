package com;

import com.entity.BookTest;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/6 21:13
 */
public class MetaObjectTest {
    @Test
    public void test() throws NoSuchFieldException {
        Object obj = new BookTest();
        Configuration configuration = new Configuration();
        MetaObject metaObject = configuration.newMetaObject(obj);
        metaObject.setValue("user.userName", "xushan");
        System.out.println(metaObject.getValue("user.userName"));
    }
}
