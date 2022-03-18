package myMap.testClass;

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
        return age == studnet.age && name.equals(studnet.name);
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
