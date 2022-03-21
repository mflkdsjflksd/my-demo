package myMybatis.session;


import myMybatis.config.Configuration;
import myMybatis.config.ConfigurationBuilder;
import myMybatis.enumType.ExecutorType;
import myMybatis.executor.BatchExecutor;

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
        if (ExecutorType.DEFAULT_EXECUTOR.getType().equals(type)) {
            return new DefaultSqlSession();
        } else if (ExecutorType.BATCH_EXECUTOR.getType().equals(type)) {
            return new BatchExecutor();
        } else {
            System.out.println("输入类型有误");
            return null;
        }

    }

    public static SqlSession getSqlSession(ExecutorType type) {
        if (ExecutorType.DEFAULT_EXECUTOR.getType().equals(type.getType())) {
            return new DefaultSqlSession();
        } else if (ExecutorType.BATCH_EXECUTOR.getType().equals(type.getType())) {
            return new BatchExecutor();
        } else {
            System.out.println("输入类型有误");
            return null;
        }

    }

}
