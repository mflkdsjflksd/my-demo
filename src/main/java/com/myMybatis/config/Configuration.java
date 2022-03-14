package com.myMybatis.config;

import com.myMybatis.MappedStatement;
import com.myCollection.myHashMap.MyHashMap;

public class Configuration {

    private MyHashMap<String, MappedStatement> mappedStatements = new MyHashMap<>();

    public MyHashMap<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }
}