package myMybatis.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/21 16:49
 */
public class LoadXML {
    public static final String RESOURCE = "myMybatis.resources.mappers";

    public LoadXML() {
        loadMappersInfo();
    }

    /**
     * @Author: xs
     * @describe: 获取xml文件信息
     * @Return:
     */
    private void loadMappersInfo() {
        File file = new File(RESOURCE);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                loadMapperInfo(f);
            }
        }
    }

    public void loadMapperInfo(File file) {
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
            Configuration.CONFIGURATION.getMappedStatements().put(sourceId, mappedStatement);
        }
    }
}
