package ink.ckx.leetcode.medium;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/14
 */
public class Solution_74 {

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 34;
        System.out.println(new Solution_74().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 将矩阵当成一维数据
            int midElement = matrix[mid / n][mid % n];
            if (target == midElement) {
                return true;
            }
            if (target > midElement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
