package java.com.myMybatis.config;


import java.com.myCollection.myHashMap.MyHashMap;
import java.com.myMybatis.MappedStatement;

public class Configuration {

    private MyHashMap<String, MappedStatement> mappedStatements = new MyHashMap<>();

    public MyHashMap<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }
}
