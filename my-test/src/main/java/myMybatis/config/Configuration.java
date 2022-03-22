package myMybatis.config;


import java.util.HashMap;
import java.util.Set;

/**
 * @Author: xs
 * @Date: 2022/3/22 15:54
 * @describe: 超级配置中心
 */
@SuppressWarnings("all")
public enum Configuration {
    CONFIGURATION;

    private HashMap<String, MappedStatement> mappedStatements;
    private HashMap<String, Set<String>> paramsMap;

    public HashMap<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(HashMap<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }

    public HashMap<String, Set<String>> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(HashMap<String, Set<String>> paramsMap) {
        this.paramsMap = paramsMap;
    }
}
