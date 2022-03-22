package myMybatis.enumType;

/**
 * @Author: xs
 * @Date: 2022/3/21 16:07
 * @describe: 执行器类型
 */
public enum ExecutorType {
    DEFAULT_EXECUTOR("default"), BATCH_EXECUTOR("batchExecutor");

    private final String type;

    ExecutorType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
