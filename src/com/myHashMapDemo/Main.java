package com.myHashMapDemo;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        MyHashMap<Studnet, Integer> myHashMap = new MyHashMap<>();
//        Studnet xs = new Studnet("xs", 1);
//        Studnet xs1 = new Studnet("xs", 2);
//        myHashMap.put(xs, 1);
//        myHashMap.put(xs1, 2);
//        System.out.println(myHashMap.get(xushan1));
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i <= 1600; i++) {
            myHashMap.put(i, i);

        }
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(32));
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(16));
//        System.out.println(myHashMap.get(1));
//        System.out.println(myHashMap.get(150000));
        HashMap<Object, Object> map = new HashMap<>();
        map.put(100, 1);
    }
}
