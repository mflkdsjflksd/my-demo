package myMybatis.config;

import myMybatis.zhujie.MyParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xs
 * @describe: //把dao文件夹内的所有方法和参数绑定
 * @date 2022/3/22 15:40
 */
public class DaoParamsBuilder {
    public void daoParamsBuilder() {
        Configuration configuration = Configuration.CONFIGURATION;
        HashMap<String, MappedStatement> map = configuration.getMappedStatements();
        HashMap<String, Set<String>> paramsMap = new HashMap<>();
        for (String key : map.keySet()) {
            //放入一个类名，代表当前类已经加载完毕
            MappedStatement mappedStatement = map.get(key);
            String namespace = mappedStatement.getNamespace();
            if (!paramsMap.containsKey(namespace)) {
                paramsMap.put(namespace, null);
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(namespace);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Method[] declaredMethods = aClass.getDeclaredMethods();
                //遍历所有的方法
                for (Method o : declaredMethods) {
                    String name = namespace + "." + o.getName();
                    Annotation[][] annotations = o.getParameterAnnotations();
                    HashSet<String> set = new HashSet<>();
                    for (Annotation[] annotation : annotations) {
                        if (annotation.length >= 1 && annotation[0] instanceof MyParam) {
                            MyParam myParam = (MyParam) annotation[0];
                            if (set.contains(myParam.value())) {
                                new Exception("自定义注解参数重复").printStackTrace();
                            }
                            set.add(myParam.value());
                        }
                    }
                    paramsMap.put(name, set);
                }
            }
        }
        configuration.setParamsMap(paramsMap);
    }
}
