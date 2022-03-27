package leetcode.middle;

import org.junit.Test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 12:37
 */
public class 搜索二维矩阵74 {
    @Test
    public void main() {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] arr1 = {{1, 3}};
        int[][] arr2 = {{-8, -7, -5, -3, -3, -1, 1}};
        System.out.println(searchMatrix(arr2, -5));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 1 && matrix[0].length == 1) {
            if (matrix[0][0] == target) return true;
            else return false;
        }
        int left = 0, right = matrix.length - 1, n = matrix[0].length - 1;
        while (left <= right) {
            int midle = (left + right) / 2;
            if (target >= matrix[midle][0] && target <= matrix[midle][n]) {
                //进行二分查找
                left = 0;
                right = n;

                while (left < right) {
                    int m = (left + right) / 2;
                    if (matrix[midle][left] == target || matrix[midle][right] == target) return true;
                    if (matrix[midle][m] == target) {
                        return true;
                    } else if (matrix[midle][m] > target) {
                        right = m - 1;
                    } else {
                        left = m + 1;
                    }
                }
                return false;
            } else if (target > matrix[midle][0]) {
                left = midle + 1;
            } else {
                right = midle - 1;
            }
        }
        return false;
    }

}
