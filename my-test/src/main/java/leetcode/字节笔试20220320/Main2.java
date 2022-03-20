package leetcode.字节笔试20220320;

import java.util.Scanner;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/20 11:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int need = Integer.parseInt(s1[0]);
        int amounts = Integer.parseInt(s1[1]);
        int[] dp = new int[need];
        for (int i = 0; i < amounts; i++) {
            String[] s = sc.nextLine().split(" ");
            if (i < need) {
                dp[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
            }
        }
        for (int i = 1; i < need; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i]);
            }
        }
        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        System.out.println(sum);
    }
}
