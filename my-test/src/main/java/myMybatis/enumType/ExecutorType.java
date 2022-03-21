package myMybatis.enumType;

/**
 * @Author: xs
 * @Date: 2022/3/21 16:07
 * @describe: 执行器类型
 */
public enum ExecutorType {
    DEFAULT("default");

    private final String type;

    private ExecutorType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
