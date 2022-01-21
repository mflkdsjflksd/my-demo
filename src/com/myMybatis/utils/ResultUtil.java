package com.myMybatis.utils;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: xs
 * @describe: 结果处理工具
 * @date 2022/1/21 14:16
 */
public class ResultUtil {
    /**
     * @Author: xs
     * @Date: 2022/1/20 21:15
     * @describe: 读取resultset中的数据，并转换成目标对象
     */
    public static <E> void handlerResultSet(ResultSet resultSet, List<E> ret, String className) {
        Class<E> clazz = null;
        try {
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                Object entity = clazz.newInstance();
                setPropToBeanFGromResultSet(entity, resultSet);
                ret.add((E) entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setPropToBeanFGromResultSet(Object entity, ResultSet resultSet) throws SQLException {
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            String name = declaredFields[i].getName();
            if (declaredFields[i].getType().getSimpleName().equals("String")) {
                String string = resultSet.getString(name);
                setPropToBean(entity, name, string);
            } else if (declaredFields[i].getType().getSimpleName().equals("int")) {
                Integer integer = resultSet.getInt(name);
                setPropToBean(entity, name, integer);
            } else if (declaredFields[i].getType().getSimpleName().equals("long")) {
                long aLong = resultSet.getLong(name);
                setPropToBean(entity, name, aLong);
            }
        }
    }

    public static void setPropToBean(Object bean, String propName, Object value) {
        Field f;
        try {
            f = bean.getClass().getDeclaredField(propName);
            f.setAccessible(true);
            f.set(bean, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void parameterize(PreparedStatement preparedStatement, Object parameter) throws SQLException {
        if (parameter instanceof Integer) {
            preparedStatement.setInt(1, (int) parameter);
        } else if (parameter instanceof Long) {
            preparedStatement.setLong(1, (long) parameter);
        } else if (parameter instanceof String) {
            preparedStatement.setString(1, (String) parameter);
        }
    }
}
