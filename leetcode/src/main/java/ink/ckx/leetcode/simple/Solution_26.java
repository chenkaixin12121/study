package ink.ckx.leetcode.simple;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/15
 */
public class Solution_26 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 6};
        System.out.println(new Solution_26().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                // 如果不相等，将快指针的值给到慢指针的下一个元素
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }
}
