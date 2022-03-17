package java.com;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/17 19:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int value = Integer.parseInt(s1[0]);
        int length = Integer.parseInt(s1[1]);
        PriorityQueue<Helper> helpers = new PriorityQueue<>((o1, o2) -> {
            return o1.goodsValue - o2.goodsValue;
        });
        for (int i = 0; i < length; i++) {
            s1 = scanner.nextLine().split(" ");
            int numbers = Integer.parseInt(s1[1]);
            if (numbers > 0) {
                helpers.add(new Helper(Integer.parseInt(s1[0]), numbers));
            }
        }
        int res = 0;
        while (value > 0 || helpers.isEmpty()) {
            Helper poll = helpers.poll();
            if (value >= poll.goodsValue * poll.amounts) {
                value -= poll.goodsValue * poll.amounts;
                res += poll.amounts;
            } else {
                while (value > 0) {
                    value -= poll.goodsValue;
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    static class Helper {
        Integer goodsValue;
        Integer amounts;

        public Helper(Integer goodsValue, Integer amounts) {
            this.goodsValue = goodsValue;
            this.amounts = amounts;
        }
    }

}
