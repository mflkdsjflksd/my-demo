package com.myHashMapDemo;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studnet studnet = (Studnet) o;

        return age == studnet.age && Objects.equals(name, studnet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
