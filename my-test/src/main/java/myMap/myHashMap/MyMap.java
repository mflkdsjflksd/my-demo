package myMap.myHashMap;


public interface MyMap<K, V> extends myMap.MyMap {
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
     * @Author: xs
     * @Date: 2022/2/15 13:50
     * @describe: 当前Map是否为空
     */
    boolean isEmpty();

    /**
     * @Author: xs
     * @Date: 2022/2/15 13:51
     * @describe: 是否包含key
     */
    boolean containsKey(K key);

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
