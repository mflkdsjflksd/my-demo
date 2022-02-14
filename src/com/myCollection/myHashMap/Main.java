package com.myCollection.myHashMap;

import com.myCollection.testClass.Studnet;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Studnet, Integer>  map= new HashMap<>();
        Studnet xs = new Studnet("xs", 1);
        Studnet xs1 = new Studnet("xs", 1);
        System.out.println(xs.hashCode());
        System.out.println(xs1.hashCode());
        map.put(xs, 1);
        map.put(xs1, 2);

        System.out.println();
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

