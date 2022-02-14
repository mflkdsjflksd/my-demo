package com.myCollection.myHashMap;

import com.myCollection.MyCollection;

public interface MyMap<K, V> extends MyCollection {
    /**
     * 定义put方法
     *
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * 定义get 方法
     *
     * @param k
     * @return
     */
    V get(K k);

    /**
     * 定义长度
     *
     * @return
     */
    int size();

    /**
     * 删除一个元素
     *
     * @param k
     * @return
     */
    boolean remove(K k);

    /**
     * 定义规范
     *
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
