package myMybatis.config;

import lombok.Data;

import java.util.List;

/**
 * @Author: xs
 * @Date: 2022/3/22 14:32
 * @describe:
 */
@Data
public class MappedStatement {
    //名字
    private String namespace;
    //资源位置
    private String sourceId;
    //结果类型
    private String resultType;
    //sql语句
    private String sql;
    //参数列表
    private List<String> paramsList;
    //采用拼接还是预处理
    private boolean pretreatmentFlag = true;

}
