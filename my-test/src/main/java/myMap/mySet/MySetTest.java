package myMap.mySet;


import myMap.testClass.Studnet;

/**
 * @Author: xs
 * @describe:
 * @date 2022/2/14 13:46
 */
public class MySetTest {
    public static void main(String[] args) {
        //测试set拉链
        /**
         * @describe: 自定义Map拉链测试
         */
        MySet<Studnet> set = new MyHashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(new Studnet(String.valueOf(i), i));
        }
        set.remove(new Studnet(String.valueOf(1), 1));
        set.remove(new Studnet(String.valueOf(2), 2));


        //测试int
        MySet<Integer> setInteger = new MyHashSet<>();
        for (int i = 0; i < 100; i++) {
            setInteger.add(i);
        }

        System.out.println(setInteger.contains(1));
        System.out.println(setInteger.remove(1));
        System.out.println(setInteger.contains(1));
        setInteger.clear();
        System.out.println(setInteger.contains(1));
        System.out.println(setInteger.isEmpty());
    }
}
