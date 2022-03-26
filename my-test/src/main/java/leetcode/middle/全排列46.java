package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/25 19:12
 */
public class 全排列46 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(arr);
    }
}

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] isVisted;

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            isVisted = new boolean[nums.length];
            isVisted[i] = true;
            temp.add(nums[i]);
            hand(nums);
            temp.remove(0);
        }
        return list;
    }

    public void hand(int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (isVisted[i]) {
                    continue;
                } else {
                    isVisted[i] = true;
                    temp.add(nums[i]);
                    hand(nums);
                    isVisted[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}