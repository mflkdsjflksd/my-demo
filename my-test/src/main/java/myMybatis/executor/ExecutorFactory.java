package myMybatis.executor;

import myMybatis.enumType.ExecutorType;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/22 11:56
 */
public class ExecutorFactory {
    public static Executor getExecutor(String type) {
        if (ExecutorType.DEFAULT_EXECUTOR.getType().equals(type)) {
            return new DefaultExecutor();
        } else if (ExecutorType.BATCH_EXECUTOR.getType().equals(type)) {
            return new BatchExecutor();
        } else {
            return null;
        }
    }

    public static Executor getExecutor(ExecutorType type) {
        if (ExecutorType.DEFAULT_EXECUTOR.getType().equals(type.getType())) {
            return new DefaultExecutor();
        } else if (ExecutorType.BATCH_EXECUTOR.getType().equals(type.getType())) {
            return new BatchExecutor();
        } else {
            return null;
        }
    }
}
