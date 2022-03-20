package leetcode.字节笔试历史题;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: xs
 * @describe:第四题
 * @date 2022/3/20 10:03
 */
public class Main4 {
    static HashMap<Character, Character> dic = new HashMap<>();

    static char[] res;

    public static void init() {
        int firstCapitalletter = 'A';
        int firstLowercaseLetter = 'a';
        for (char i = 0; i < 26; i++) {
            char d = (char) (firstCapitalletter + i);
            char x = (char) (firstLowercaseLetter + i);
            dic.put(d, x);
            dic.put(x, d);
        }
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int length = Integer.parseInt(s[1]);
        res = scanner.nextLine().toCharArray();
        for (int i = 0; i < length; i++) {
            s = scanner.nextLine().split(" ");
            helper(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            builder.append(res[i]);
        }
        System.out.println(builder);
    }

    public static void helper(int left, int end) {
        for (int start = left; start < end; start++) {
            char re = res[start];
            res[start] = dic.get(re);
        }
    }


}
