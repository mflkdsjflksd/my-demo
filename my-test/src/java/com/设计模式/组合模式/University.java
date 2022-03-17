package java.com.设计模式.组合模式;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/12 16:16
 */
public class University extends OrganizationComponent {
    List<OrganizationComponent> list = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        list.add(organizationComponent);
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        list.remove(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println("=======" + super.getName() + "=======");
        for (OrganizationComponent organizationComponent : list) {
            organizationComponent.print();
        }
    }
}
