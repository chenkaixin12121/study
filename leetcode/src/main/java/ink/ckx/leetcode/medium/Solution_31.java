package ink.ckx.leetcode.medium;

import java.util.Arrays;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/14
 */
public class Solution_31 {

    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须 原地 修改，只允许使用额外常数空间
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 7, 6, 2};
        new Solution_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        // 从右至左，找到第一个升序子序列
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        // 如果全部降序，输出最小序列
        if (k < 0) {
            Arrays.sort(nums);
            return;
        }
        // 找到比 k 大的一个数（最接近 k 的）i
        int i = k + 2;
        while (i < nums.length && nums[i] > nums[k]) {
            i++;
        }
        // 交换两个数
        int temp = nums[k];
        nums[k] = nums[i - 1];
        nums[i - 1] = temp;
        // 将 i 之后的数据升序排列
        int start = k + 1;
        int end = nums.length - 1;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}