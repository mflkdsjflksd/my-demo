package com.myCollection.myHashMap;

import com.myCollection.testClass.Studnet;

import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        /**
         * @describe: 自定义Map拉链测试
         */
        MyMap<Studnet, Integer> stuMap = new MyHashMap<>();
        for (int i = 0; i < 200; i++) {
            Integer put = stuMap.put(new Studnet(String.valueOf(i), i), i);
            System.out.println(put);
        }
        stuMap.remove(new Studnet(String.valueOf(1), 1));
        stuMap.remove(new Studnet(String.valueOf(2), 2));
        System.out.println("========================");
        /**
         * @describe: int类型数据测试
         */
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
    }
}

