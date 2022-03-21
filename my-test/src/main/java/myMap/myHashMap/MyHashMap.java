package myMap.myHashMap;


public class MyHashMap<K, V> implements MyMap<K, V> {
    /**
     * @describe: 负载因子
     */
    private float CRITICAL_VALUE = 0.75f;
    private Entry<K, V>[] mapTable = null;
    private int mapLength = 16;
    /**
     * @describe: 临界值;
     */
    private int threshold = getThreshold();
    /**
     * @describe: 结点个数
     */
    private int size = 0;
    /**
     * @describe: map最大长度
     */
    private int MAX_TABLE_LENGTH = Integer.MAX_VALUE;

    public MyHashMap() {
    }

    public MyHashMap(int mapLength, float loadFactor) throws Exception {
        if (mapLength < 0) {
            throw new Exception("数组长度应该为负数");
        }
        if (loadFactor <= 0 || loadFactor >= 1) {
            throw new Exception("负载因子应该大于0且小于1");
        }
        this.mapLength = mapLength;
        threshold = getThreshold();
        this.CRITICAL_VALUE = loadFactor;
    }

    /**
     * 计算哈希值，判断哈希值位置是否为空
     * true 直接放入
     * <p>
     * false 如果找到相同值，替换，否者插入到链表最后
     *
     * @param key
     * @param value
     * @return 最新的value
     */
    @Override
    public V put(K key, V value) {
        Entry<K, V>[] tab;
        if ((tab = validaResize()) != null) {
            mapTable = tab;
        }

        int index = getIndex(key);
        Entry<K, V> entry = mapTable[index];

        if (entry == null) {
            mapTable[index] = new Entry<>(key, value, null);
        } else {
            V oldValue;
            while (entry.next != null) {
                if (entry.getKey().equals(key) && entry.getKey() == key) {
                    oldValue = entry.getValue();
                    entry.value = value;
                    return oldValue;
                } else {
                    entry = entry.next;
                }
            }
            entry.next = new Entry<>(key, value, null);
        }
        size++;
        return value;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 21:57
     * @describe: 验证扩容
     */
    private Entry<K, V>[] validaResize() {
        Entry<K, V>[] kvEntry = null;
        //如果当前数组未初始化，初始化数组
        if (this.mapTable == null) {
            Entry<K, V>[] newmapTable = new Entry[mapLength];
            return newmapTable;
        }
        //当前需要扩容
        else if (size >= (this.threshold)) {
            mapLength <<= 1;
            threshold <<= 1;
            return resize(new Entry[mapLength]);
        }
        return null;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 21:57
     * @describe: 扩容
     */
    private Entry<K, V>[] resize(Entry<K, V>[] newmapTable) {
        int index;
        for (Entry entry : mapTable) {
            Entry<K, V> temp;
            while (entry != null) {
                index = getIndex(entry.getKey());
                if (newmapTable[index] != null) {
                    temp = entry;
                    entry = entry.next;
                    temp.next = newmapTable[index];
                    newmapTable[index] = temp;
                } else {
                    newmapTable[index] = entry;
                    entry = entry.next;
                    newmapTable[index].next = null;
                }
            }
        }
        return newmapTable;
    }

    /**
     * 根据key 获取value
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if (mapLength == 0) {
            return null;
        }
        int index = getIndex(k);
        Entry<K, V> kvEntry = mapTable[index];
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
     * @param key
     * @key
     */
    @Override
    public boolean remove(K key) {
        int idnex = getIndex(key);
        if (mapTable == null || size == 0 || mapTable[idnex] == null) {
            return false;
        }
        if (mapTable[idnex] == null) {
            return false;
        } else if (mapTable[idnex].getKey() == key && mapTable[idnex].getKey().equals(key)) {
            mapTable[idnex] = mapTable[idnex].next;
            size--;
            return true;
        } else {
            Entry temp = mapTable[idnex];
            while (temp.next != null) {
                if (temp.next.getKey().equals(key) && temp.next.getKey().hashCode() == key.hashCode()) {
                    temp.next = temp.next.next;
                    size--;
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (mapTable[getIndex(key)] != null) {
            Entry tempEntry = mapTable[getIndex(key)];
            while (tempEntry != null) {
                if (tempEntry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 15:20
     * @describe: 临界值计算
     */
    private int getThreshold() {
        return (int) Math.ceil(mapLength * CRITICAL_VALUE);
    }

    /**
     * 计算哈希码，并取模
     *
     * @param key
     * @return
     */
    private int getIndex(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return Math.abs((h ^ (h >>> 16)) % this.mapLength);
    }

    /**
     * @Author: xs
     * @Date: 2022/2/15 11:46
     * @describe: 存储数据
     */
    class Entry<K, V> implements MyMap.Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
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
}
