package ink.ckx.leetcode.medium;

import java.util.Arrays;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/14
 */
public class Solution_48 {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution_48().rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        print("原数据", matrix);
        
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print("翻转矩阵", matrix);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        print("翻转行", matrix);
    }
    
    private void print(String msg, int[][] matrix) {
        System.out.println(msg + "------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}