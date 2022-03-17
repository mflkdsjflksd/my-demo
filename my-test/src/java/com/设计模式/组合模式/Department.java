package java.com.设计模式.组合模式;

import com.设计模式.组合模式.OrganizationComponent;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 16:25
 */
public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
