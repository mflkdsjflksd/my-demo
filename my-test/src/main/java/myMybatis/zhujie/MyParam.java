package myMybatis.zhujie;

import java.lang.annotation.*;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/22 14:10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface MyParam {
    String value();
}