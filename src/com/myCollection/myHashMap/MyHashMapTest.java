package com.myCollection.myHashMap;

import com.myCollection.testClass.Studnet;


public class MyHashMapTest {
    public static void main(String[] args) {
        //自定义测试
        MyMap<Studnet, Integer> stuMap = new MyHashMap<>();
        int length = 3;
        for (int i = 0; i < length; i++) {
            Integer put = stuMap.put(new Studnet(String.valueOf(i), i), i);
            System.out.println(put);
        }
        stuMap.remove(new Studnet(String.valueOf(1), 1));
        stuMap.remove(new Studnet(String.valueOf(2), 2));

        //int测试数据
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i <= 1600; i++) {
            myHashMap.put(i, i);
        }
        System.out.println(myHashMap.get(0));
        myHashMap.remove(0);
        System.out.println(myHashMap.get(32));
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(16));
        System.out.println(myHashMap.get(1600));
        System.out.println(myHashMap.containsKey(1600));
        System.out.println(myHashMap.isEmpty());
    }
}

