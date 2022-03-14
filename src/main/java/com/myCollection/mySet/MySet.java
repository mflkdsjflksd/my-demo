package com.myCollection.mySet;


import com.myCollection.MyCollection;

public interface MySet<T> extends MyCollection {

    /**
     * @Author: xs
     * @Date: 2022/2/14 10:34
     * @describe: 添加set
     */
    boolean add(T key);

    /**
     * @Author: xs
     * @Date: 2022/2/14 10:35
     * @describe: 删除key
     */
    boolean remove(T key);

    /**
     * @Author: xs
     * @Date: 2022/2/14 10:39
     * @describe: 是否含有key
     */
    boolean contains(T key);

    /**
     * @Author: xs
     * @Date: 2022/2/14 10:41
     * @describe: 返回长度
     */
    int size();

    /**
     * @Author: xs
     * @Date: 2022/2/14 10:42
     * @describe: 清理当前set
     */
    void clear();
    /**
     * @Author: xs
     * @Date: 2022/2/15 14:25
     * @describe: 判断当前map是否为null
     */
    boolean isEmpty();
    /**
     * @Author: xs
     * @Date: 2022/2/15 14:25
     * @describe: 存放数据类
     */
    interface Entry<K, V> {
        K getKey();
    }
}
