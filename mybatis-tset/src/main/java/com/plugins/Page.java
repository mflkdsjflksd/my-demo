package com.plugins;

import lombok.Data;

/**
 * @Author: xs
 * @describe: 分页
 * @date 2022/3/10 21:06
 */
@Data
public class Page {
    /**
     * @describe: 总数量
     */
    private int total;
    /**
     * @describe: 总页数
     */
    private int totalPage;
    /**
     * @describe: 起始页
     */
    private int index;
    /**
     * @describe: 每页数量
     */
    private int size;

    public int getOffset() {
        return size * (index - 1);
    }

    public Page(int index, int size) {
        this.index = index;
        this.size = size;
    }
}
