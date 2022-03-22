package myMybatis.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/21 16:49
 */
public class LoadXML {
    public static final String RESOURCE = "E:\\project\\my-demo-master\\my-test\\src\\main\\java\\myMybatis\\resources\\mappers";

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
            if (element.attribute("id") == null) {
                continue;
            }
            MappedStatement mappedStatement = new MappedStatement();
            //获取xml信息；
            String id = element.attribute("id").getData().toString();
            String resultType = element.attribute("resultType").getData().toString();
            String sql = element.getData().toString();
            String sourceId = namespace + "." + id;
            //处理sql语句，把里面的#{}符号转变成一个list对象,并把处理过的的结果放入到mappedStatement中
            handleSql(mappedStatement, sql);
            //填充
            mappedStatement.setSourceId(sourceId);
            mappedStatement.setNamespace(namespace);
            mappedStatement.setResultType(resultType);
            //添加容器
            Configuration.CONFIGURATION.getMappedStatements().put(sourceId, mappedStatement);
        }
    }

    private void handleSql(MappedStatement mappedStatement, String sql) {
        StringBuilder sqlBuilder = new StringBuilder();
        StringBuilder tempParams = new StringBuilder();
        char flag = '}';
        char[] sqlArr = sql.toCharArray();
        ArrayList<String> params = new ArrayList<>();
        for (int i = 0; i < sqlArr.length; i++) {
            if (sqlArr[i] == '$') {
                mappedStatement.setPretreatmentFlag(false);
            }
            if (sqlArr[i] == '#' && i + 1 < sqlArr.length && sqlArr[i + 1] == '{') {
                sqlBuilder.append(" ? ");
                i += 2;
                while (sqlArr[i] != flag) {
                    tempParams.append(sqlArr[i++]);
                }
                params.add(tempParams.toString());
                tempParams.delete(0, tempParams.length());
            } else {
                sqlBuilder.append(sqlArr[i]);
            }
        }

        mappedStatement.setParamsList(params);
        mappedStatement.setSql(sqlBuilder.toString());
    }
}
