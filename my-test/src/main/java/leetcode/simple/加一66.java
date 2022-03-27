package leetcode.simple;

import org.junit.Test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 11:58
 */
public class 加一66 {
    @Test
    public void main() {

    }

    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0) {
                return new int[]{1};
            }
            if (digits.length == 1 && digits[0] == 9) {
                return new int[]{1, 0};
            }
            digits[digits.length - 1] += 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 10 && i >= 1) {
                    digits[i] = 0;
                    digits[i - 1] += 1;
                }
            }
            if (digits[0] == 10) {
                int[] res = new int[digits.length + 1];
                digits[0] = 1;
                digits[1] = 0;
                for (int i = 2; i < digits.length; i++) {
                    res[i] = digits[i];
                }
                return res;
            }
            return digits;
        }
    }
}
