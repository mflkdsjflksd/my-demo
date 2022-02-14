package com.myCollection.mySet;

/**
 * @Author: xs
 * @describe:
 * @date 2022/2/14 13:46
 */
public class Main {
    public static void main(String[] args) {
        MySet<Integer> set = new MyHashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        System.out.println(set.contains(1));
        System.out.println(set.remove(1));
        System.out.println(set.contains(1));
        set.clear();
        System.out.println(set.contains(1));
        System.out.println();
    }
}
