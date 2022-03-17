package java.com.设计模式.组合模式;



import java.util.Arrays;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 16:26
 */
public class Main {
    public static void main(String[] args) {
        University university = new University("清华大学", "国家顶级大学");
        College college = new College("计算机学院", "计算机学院描述");
        College college1 = new College("信息工程学院", "信息工程学院");
        college.add(new Department("软件工程", "软件工程描述"));
        college.add(new Department("网络工程", "网络工程描述"));
        college1.add(new Department("通信工程", "通信工程描述"));
        college1.add(new Department("信息工程", "信息工程描述"));
        university.add(college);
        university.add(college1);
    }
}