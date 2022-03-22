package myMybatis.session;


import myMybatis.config.Configuration;
import myMybatis.config.ConfigurationBuilder;
import myMybatis.enumType.ExecutorType;


/**
 * @author: xs
 * @describe:
 */

public class SqlSessionFactory {
    static Configuration build;

    static {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        build = configurationBuilder.build();
    }

    public static SqlSession getSqlSession(String type) {
        return new DefaultSqlSession(type);
    }

    public static SqlSession getSqlSession(ExecutorType type) {
        return new DefaultSqlSession(type.getType());
    }


}
