package leetcode.simple;

import org.junit.Test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 12:10
 */
public class 二进制求和67 {
    @Test
    public void main() {
        System.out.println(addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );

    }


}
