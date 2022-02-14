package com.myCollection.mySet;

/**
 * @Author: xs
 * @describe:
 * @date 2022/2/14 10:32
 */

class MyHashSet<T> implements MySet<T> {
    Entry<T>[] table;

    /**
     * @describe: 初始长度
     */
    int TABLE_LENGTH = 16;

    /**
     * @describe: 负载因子
     */
    double CRITICAL_VALUE = 0.75;

    /**
     * @describe: 临界值
     */
    int threshold = getThreshold();

    /**
     * @describe: 当前数组有效数据长度
     */
    int size = 0;


    /**
     * @describe: 存放数据类
     */
    class Entry<T> {
        T key;
        Entry next;

        public Entry(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }

    public MyHashSet() {
    }

    public MyHashSet(int length) {
        this.TABLE_LENGTH = length;
        //重新计算临界值
        threshold = getThreshold();
    }

    @Override
    public boolean add(T key) {
        Entry<T>[] tab;
        //验证扩容，
        if ((tab = validaResize()) != null) {
            this.table = tab;
        }
        /**
         * @describe: 插入方法，通过计算索引，如果当前索引位置为null直接插入，否者插入链表,并在插入链表时判断是否已经存在
         */
        int index = getHashCode(key);
        Entry<T> newEntry = new Entry<>(key);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            if (table[index] == null) {
                table[index] = newEntry;
            } else {
                Entry temp = table[index];
                while (temp.next != null) {
                    if (temp.getKey().equals(key)) {
                        return false;
                    }
                    temp = temp.next;
                }
                temp.next = newEntry;
            }
        }
        /**
         * @describe: 当前是否需要扩容
         */
        size++;
        return true;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 13:53
     * @describe: 三种情况：
     * 1 如果当前key计算得出的索引位置为null,返回false
     * 2 如果当前结点就是要删除的结点，当前结点指向下一个结点，如果为空长度 -1；
     * 3 循环判断链表，如果有让当前结点指向当前节点的下一个的下一个，判了当前的下一个不等于null；
     */
    @Override
    public boolean remove(T key) {
        int index = getHashCode(key);
        Entry<T> temp = table[index];
        if (temp == null) {
            return false;
        } else if (key == temp.getKey() || temp.getKey().equals(key)) {
            table[index] = table[index].next;
            if (table[index] == null) {
                size--;
            }
            return true;
        } else {
            while (temp.next != null) {
                if (temp.next.getKey() == key || temp.next.getKey().equals(key)) {
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
     * @Author: xs
     * @Date: 2022/2/14 14:52
     * @describe: 当前是存在key
     */
    @Override
    public boolean contains(T key) {
        int index = getHashCode(key);
        if (table[index] == null) {
            return false;
        } else {
            Entry<T> temp = table[index];
            while (!temp.getKey().equals(key)) {
                temp = temp.next;
            }
            if (temp == null) {
                return false;
            }
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        table = new Entry[16];
        TABLE_LENGTH = 16;
        size = 0;
        threshold = getThreshold();
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 15:44
     * @describe: 初始化table和验证是否需要扩容
     */
    private Entry<T>[] validaResize() {
        Entry<T>[] newTable = null;
        if (table == null) {
            newTable = new Entry[TABLE_LENGTH];
        }
        /**
         * @describe: 需要扩容
         */
        else if (size >= threshold) {
            TABLE_LENGTH <<= 1;
            threshold <<= 1;
            newTable = resize(new Entry[TABLE_LENGTH]);
        }
        return newTable;
    }

    /**
     * @Author: xs
     * @Date: 2022/2/14 15:46
     * @describe: 扩容方法
     */
    private Entry<T>[] resize(Entry<T>[] newTable) {
        int index;
        for (Entry entry : table) {
            Entry<T> temp;
            //如果当前结点不为null，替他寻找新的索引位置，可能存的链表，需要循环
            while (entry != null) {
                //重新计算该节点的hash值；
                index = getHashCode(entry.getKey());
                //如果要添加的位置已经有节点了，添加新的结点采用头插法,避免循环链表时间复杂度变高；
                if (table[index] != null) {
                    temp = entry;
                    entry = entry.next;
                    newTable[index] = temp;
                    temp.next = null;
                } else {
                    //否者直接添加到对应位置，并截断next；
                    newTable[index] = entry;
                    entry = entry.next;
                    newTable[index].next = null;
                }
            }

        }
        return newTable;
    }


    private int getThreshold() {
        return (int) Math.ceil(TABLE_LENGTH * CRITICAL_VALUE);
    }

    private int getHashCode(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return Math.abs((h ^ (h >>> 16)) % this.TABLE_LENGTH);
    }

}
