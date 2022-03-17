package java.com.设计模式.单例模式;

import com.设计模式.单例模式.DoubleCheck;
import com.设计模式.单例模式.EnumClass;
import com.设计模式.单例模式.StaticInternalClass;

/**
 * @Author: xs
 * @describe: 测试类
 * @date 2022/3/11 13:31
 */
public class Main {
    public static void main(String[] args) {
        DoubleCheck instance = DoubleCheck.getInstance();
        instance.test();
        EnumClass enumClass = EnumClass.ENUM_CLASS;
        enumClass.test();
        StaticInternalClass staticInternalClass = StaticInternalClass.getStaticInternalClass();
        staticInternalClass.test();
    }
}
