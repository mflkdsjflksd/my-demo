package java.com.设计模式.解释器模式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/8 19:38
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        HashMap<Character, Integer> value = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(value));

    }

    public static String getExpStr() throws IOException {
        System.out.println("请输入表达式");
        return new BufferedReader((new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<Character, Integer> getValue(String expStr) throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = expStr.toCharArray();
        for (Character ch : chars) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(ch)) {
                    System.out.println("请输入：" + ch + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(ch, Integer.valueOf(in));
                }

            }
        }
        return map;
    }

}
