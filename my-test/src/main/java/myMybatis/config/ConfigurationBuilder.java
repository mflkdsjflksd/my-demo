package myMybatis.config;

import java.util.HashMap;

/**
 * @Author: xs
 * @describe: 配置类构建者
 * @date 2022/3/21 15:56
 */
public class ConfigurationBuilder {

    HashMap<String, MappedStatement> mappedStatements = new HashMap<>();


    public Configuration build() {
        Configuration configuration = Configuration.CONFIGURATION;
        configuration.setMappedStatements(mappedStatements);
        //①处理xml文件②替换xml静态语句中的#{}替换为？，并记录里面的变量名字
        new LoadXML();
        new DaoParamsBuilder().daoParamsBuilder();

        return configuration;
    }


}
