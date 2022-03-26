package leetcode.剑指;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/25 20:36
 */
public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        class Solution {
            public int translateNum(int num) {
                char[] chars = String.valueOf(num).toCharArray();
                int res = 1;
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i - 1] - '0' <= 1) {
                        res += 2;
                    } else if (chars[i] - '0' <= 5) {
                        res += 2;
                    }
                }
                return res;
            }
        }
    }
}
