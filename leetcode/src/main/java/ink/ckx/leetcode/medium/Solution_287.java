package ink.ckx.leetcode.medium;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/14
 */
public class Solution_287 {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new Solution_287().findDuplicate2(nums));
    }

    public int findDuplicate(int[] nums) {
        // 左右指针
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            // 计算中间值
            int mid = (left + right) / 2;
            // 对当前的mid计算count值
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 判断count和mid本身的大小关系
            if (count <= mid) {
                // count小于等于mid自身，说明mid比target小，左指针右移
                left = mid + 1;
            } else {
                right = mid;
            }
            // 左右指针重复时，找到target
            if (left == right) {
                return left;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // 定义快慢指针
        int fast = 0;
        int slow = 0;
        // 寻找环内相遇点
        do {
            // 快指针走两步，慢指针走一步
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        // 寻找环的入口点
        // 另外定义两个指针，固定间距
        int before = 0;
        int after = slow;
        while (before != after) {
            before = nums[before];
            after = nums[after];
        }
        // 循环结束，相遇点就是环的入口点，也就是重复元素
        return before;
    }
}