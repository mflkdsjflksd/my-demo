package com.myMybatis.session;

import com.myMybatis.MappedStatement;
import com.myMybatis.config.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @author: xs
 * @describe:
 */
public class SqlSessionSingleton {
    /**
     * @describe: 初始化实例对象
     */
    private static final Configuration conf;
    /**
     * @describe: xml文件夹
     */
    public static final String MAPPER_CONFIG_LOCATION = "src/com/MyMybatis/mappers";

    static {
        conf = new Configuration();
        loadMappersInfo();
    }

    private SqlSessionSingleton() {
    }

    public static SqlSession getSqlSession() {
        return new DefaultSqlSession(conf);
    }

    /**
     * @Author: xs
     * @describe: 获取xml文件信息
     * @Return:
     */
    private static void loadMappersInfo() {
        File file = new File(MAPPER_CONFIG_LOCATION);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                loadMapperInfo(f);
            }
        }
    }

    public static void loadMapperInfo(File file) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        String namespace = root.attribute("namespace").getData().toString();
        root.addElement("update");
        root.addElement("select");
        root.addElement("delete");
        root.addElement("insert");
        List<Element> selects = root.elements();

        for (Element element : selects) {
            MappedStatement mappedStatement = new MappedStatement();

            if (element.attribute("id") == null) {
                continue;
            }
            //获取xml信息；
            String id = element.attribute("id").getData().toString();
            String resultType = element.attribute("resultType").getData().toString();
            String sql = element.getData().toString();
            String sourceId = namespace + "." + id;
            //填充
            mappedStatement.setSourceId(sourceId);
            mappedStatement.setSql(sql);
            mappedStatement.setNamespace(namespace);
            mappedStatement.setResultType(resultType);
            //添加容器
            conf.getMappedStatements().put(sourceId, mappedStatement);
        }
    }
}
