package myMybatis.config;


import myMap.myHashMap.MyHashMap;
import myMybatis.MappedStatement;

public class Configuration {

    private MyHashMap<String, MappedStatement> mappedStatements = new MyHashMap<>();

    public MyHashMap<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }
}
