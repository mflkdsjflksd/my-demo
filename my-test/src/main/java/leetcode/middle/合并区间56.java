package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/26 22:54
 */
public class 合并区间56 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 6};
        int[] arr3 = {8, 10};
        int[] arr4 = {15, 18};
        int[][] nums = {arr1, arr2, arr3, arr4};
        int[][] nums2 = {{1, 4}, {0, 2}, {3, 5}};
        new Solution().merge(nums2);
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][0];
            }

            Arrays.sort(intervals, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            ArrayList<int[]> res = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                res.add(intervals[i]);
            }
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
            int[][] ans = new int[res.size()][];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }
}
