package com.设计模式.组合模式;

import lombok.Data;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 16:14
 */
@Data
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    protected void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }
    /**
     * @Author: xs
     * @Date: 2022/3/12 16:16
     * @describe: 打印方法
     */
    public abstract void print();
}
