package myMybatis.config;


import myMap.myHashMap.MyHashMap;

@SuppressWarnings("all")
public enum Configuration {
    CONFIGURATION;

    private MyHashMap<String, MappedStatement> mappedStatements;

    public MyHashMap<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(MyHashMap<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }
}
