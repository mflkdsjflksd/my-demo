package com.myCollection.myHashMap;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Entry<K, V>[] table = null;

    private int length = 16;
    /**
     * @describe: 负载因子
     */
    private static final double CRITICAL_VALUE = 0.75;
    /**
     * @describe: 临界值;
     */
    private int threshold = getThreshold();

    private int size = 0;

    class Entry<K, V> implements MyMap.Entry<K, V> {
        K key;
        V value;
        int index;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    public MyHashMap() {
    }

    public MyHashMap(int length) {
        this.length = length;
        threshold = getThreshold();
    }

    /**
     * 计算哈希值，判断哈希值位置是否为空
     * true 直接放入
     * <p>
     * false 如果找到相同值，替换，否者插入到链表最后
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        Entry<K, V>[] tab;
        if ((tab = validaResize()) != null) {
            this.table = tab;
        }

        int index = getHashCode(k);
        Entry<K, V> kvEntry = table[index];

        if (kvEntry == null) {
            table[index] = new Entry<>(k, v, null);
            size++;
        } else {
            V oldValue;
            while (kvEntry.next != null) {
                if (kvEntry.getKey().equals(k)) {
                    oldValue = kvEntry.getValue();
                    kvEntry.value = v;
                    return oldValue;
                } else {
                    kvEntry = kvEntry.next;
                }
            }
            kvEntry.next = new Entry<>(k, v, null);
        }
        return table[index].getValue();
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 21:57
     * @describe: 验证扩容
     */
    private Entry<K, V>[] validaResize() {
        Entry<K, V>[] kvEntry = null;
        //如果当前数组未初始化，初始化数组
        if (this.table == null) {
            Entry<K, V>[] newTable = new Entry[length];
            return newTable;
        }
        //当前需要扩容
        else if (size >= (this.threshold)) {
            length <<= 1;
            threshold <<= 1;
            return resize(new Entry[length]);
        }
        return null;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 21:57
     * @describe: 扩容
     */
    private Entry<K, V>[] resize(Entry<K, V>[] newTable) {
        int index;
        for (Entry entry : table) {
            Entry<K, V> temp;
            while (entry != null) {
                index = getHashCode(entry.getKey());
                if (newTable[index] != null) {
                    temp = entry;
                    entry = entry.next;
                    temp.next = newTable[index];
                    newTable[index] = temp;
                } else {
                    newTable[index] = entry;
                    entry = entry.next;
                    newTable[index].next = null;
                }
            }

        }
        return newTable;
    }

    /**
     * 根据key 获取value
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        int index = getHashCode(k);
        Entry<K, V> kvEntry = table[index];
        return findValueByKey(k, kvEntry);
    }

    /**
     * 寻找value
     * 找到返回value 找不到返回null
     *
     * @param k
     * @param kvEntry
     * @return
     */
    private V findValueByKey(K k, Entry<K, V> kvEntry) {
        if (kvEntry != null && (k == kvEntry.getKey() || kvEntry.getKey().equals(k))) {
            return kvEntry.getValue();
        } else {
            while (kvEntry != null) {
                if (k == kvEntry.getKey() || kvEntry.getKey().equals(k)) {
                    return kvEntry.getValue();
                }
                kvEntry = kvEntry.next;
            }
        }
        return null;
    }

    /**
     * 删除一个key value
     *
     * @param k
     * @return
     */
    @Override
    public boolean remove(K k) {
        int idnex = getHashCode(k);
        if (table[idnex] == null) {
            return false;
        } else if (table[idnex].getKey() == k || table[idnex].getKey().equals(k)) {
            table[idnex] = table[idnex].next;
            if (table[idnex] == null) {
                size--;
            }
            return true;
        } else {
            Entry temp = table[idnex];
            while (temp.next != null) {
                if (temp.next.getKey() == k || temp.next.getKey().equals(k)) {
                    temp.next = temp.next.next;
                    return true;
                } else {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    /**
     * 链表的长度
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 15:20
     * @describe: 临界值计算
     */
    private int getThreshold() {
        return (int) Math.ceil(length * CRITICAL_VALUE);
    }

    /**
     * 计算哈希码，并取模
     *
     * @param key
     * @return
     */
    private int getHashCode(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return Math.abs((h ^ (h >>> 16)) % this.length);
    }
}
