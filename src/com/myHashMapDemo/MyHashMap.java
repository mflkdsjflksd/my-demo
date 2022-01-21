package com.myHashMapDemo;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Entry<K, V>[] table = null;

    private int mapLength = 16;
    //计算临界值负载因子
    private static final double CRITICAL_VALUE = 0.75;
    //临界值 扩容
    private int threshold = (int) Math.ceil(mapLength * CRITICAL_VALUE);

    private int size = 0;

    class Entry<K, V> implements MyMap.Entry<K, V> {
        K key;
        V value;
        int index;
        Entry<K, V> next;

        public Entry(K key, V value, int index, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.index = index;
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
        table = new Entry[mapLength];
    }

    public MyHashMap(int mapLength) {
        this.mapLength = mapLength;
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
        if ((tab = resize()) != null) {
            this.table = tab;
        }
        int index = hashCode(k);
        Entry<K, V> kvEntry = table[index];
        if (kvEntry == null) {
            table[index] = new Entry<>(k, v, index, null);
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
            kvEntry.next = new Entry<>(k, v, index, null);
        }
        return table[index].getValue();
    }

    /**
     * 扩容方法
     */
    private Entry<K, V>[] resize() {
        Entry<K, V>[] kvEntry = null;
        if (this.table == null) {
            Entry<K, V>[] entries = new Entry[mapLength];
            return entries;
        } else if (size >= (this.threshold)) {
            this.mapLength = this.mapLength * 2;
            this.threshold *= 2;
            kvEntry = new Entry[this.mapLength];
            int hashCode;
            for (Entry entry : table) {
                if (entry == null) {
                    continue;
                }
                //如果当前元素是链表，计算每一个元素的哈希值
                if (entry.next != null) {
                    while (entry != null) {
                        kvEntry[hashCode(entry)] = entry;
                        entry = entry.next;
                    }
                }
                //直接添加
                else {
                    hashCode = hashCode(entry.getKey());
                    kvEntry[hashCode] = entry;
                }
            }
        }
        return kvEntry;
    }

    /**
     * 根据key 获取value
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        int index = hashCode(k);
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
        int hashCode = hashCode(k);
        if (table[hashCode] == null) {
            return false;
        } else if (table[hashCode].getKey() == k || table[hashCode].getKey().equals(k)) {
            table[hashCode] = table[hashCode].next;
            size--;
            return true;
        } else {
            Entry temp = table[hashCode];
            while (temp.next != null) {
                if (temp.next.getKey() == k || temp.next.getKey().equals(k)) {
                    temp.next = temp.next.next;
                    return true;
                } else {
                    temp = temp.next;
                }
            }
        }
        return false;
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
     * 计算哈希码，并取模
     *
     * @param key
     * @return
     */
    private int hashCode(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return Math.abs((h ^ (h >>> 16)) % this.mapLength);
    }
}
