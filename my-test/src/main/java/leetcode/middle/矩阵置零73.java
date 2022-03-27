package leetcode.middle;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 13:22
 */
public class 矩阵置零73 {
    boolean[][] isvisited;

    @Test
    public void main() {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] arr1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr1);
    }

    public void setZeroes(int[][] matrix) {
        isvisited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !isvisited[i][j]) {
                    hand(matrix, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(matrix));
    }

    public void hand(int[][] matrix, int i, int j) {
        if (isvisited[i][j] || i >= matrix.length || j >= matrix[0].length) return;
        //处理行
        isvisited[i][j] = true;
        int temp = 0;
        //处理右
        for (; temp < matrix[0].length; temp++) {
            if (matrix[i][temp] == 0 && !isvisited[i][temp]) {
                hand(matrix, i, temp);
            } else {
                isvisited[i][temp] = true;
                matrix[i][temp] = 0;
            }
        }
        //处理列
        i = 0;
        for (; i < matrix.length; i++) {
            if (matrix[i][j] == 0 && !isvisited[i][j]) {
                hand(matrix, i, j);
            } else {
                isvisited[i][j] = true;
                matrix[i][j] = 0;
            }
        }
    }
}
