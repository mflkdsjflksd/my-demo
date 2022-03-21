package myMybatis.config;

import myMap.myHashMap.MyHashMap;

/**
 * @Author: xs
 * @describe: 配置类构建者
 * @date 2022/3/21 15:56
 */
public class ConfigurationBuilder {

    MyHashMap<String, MappedStatement> mappedStatements = new MyHashMap<>();

    public Configuration build() {
        Configuration configuration = Configuration.CONFIGURATION;
        configuration.setMappedStatements(mappedStatements);
        new LoadXML();
        return configuration;
    }


}
