package com.myCollection.testClass;

import java.util.Objects;

public class Studnet {
    private String name;
    private int age;

    public Studnet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
