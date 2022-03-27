package leetcode.middle;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 10:59
 */
public class 插入区间57 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length == 0) {
                int[][] res = {newInterval};
                return res;
            }
            ArrayList<int[]> res = new ArrayList<>();
            res.add(newInterval);
            for (int i = 0; i < intervals.length; i++) {
                res.add(intervals[i]);
            }
            Collections.sort(res, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            // 14 4 5
            for (int i = 0; i < res.size() - 1; ) {
                int[] currentArr = res.get(i);
                int[] nextArr = res.get(i + 1);
                //当前第一个比下一个第一个小，并且第二个比第一个大并且第二个比比第二个大；如[1,4] [2,3]
                if (currentArr[0] <= nextArr[0] && currentArr[1] >= nextArr[0] && currentArr[1] >= nextArr[1]) {
                    res.remove(i + 1);
                }
                //当前第一个比下一个第一个小，并且第二个比第一个大并且第二个比比第二个小；如[1,4]
                else if (currentArr[0] <= nextArr[0] && currentArr[1] >= nextArr[0]) {
                    currentArr[1] = nextArr[1];
                    res.remove(i + 1);
                } //当前第一个比下一个第一个大，并且第二个比第一个大并且第二个比比第二个大；如[2,3][1,4]
                else if (currentArr[0] >= nextArr[0] && currentArr[1] > nextArr[0] && currentArr[1] < nextArr[1]) {
                    res.remove(i);
                } //当前第一个比下一个第一个大，并且第二个比第一个大并且第二个比比第二个大；如[2,5][1,4]
                else if (currentArr[0] >= nextArr[0] && currentArr[1] > nextArr[0] && currentArr[1] > nextArr[1]) {
                    res.remove(i);
                    nextArr[1] = currentArr[1];
                } else {
                    i++;
                }

            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
