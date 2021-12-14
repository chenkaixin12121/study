package ink.ckx.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/13
 */
public class Solution_15 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 0, 0};
        System.out.println(new Solution_15().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 使用双指针法，先排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果核心数大于0，则直接退出，因为结果肯定大于0
            if (nums[i] > 0) {
                break;
            }
            // 如果核心数和上一个核心数相等，则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左指针和右指针
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[l]);
                    tempList.add(nums[r]);
                    resultList.add(tempList);
                    // 三数和为0，左指针+1，右指针-1
                    l++;
                    r--;
                    // 如果左指针+1的位置和原左指针元素相同，则再+1
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    // 如果右指针-1的位置和原右指针元素相同，则再-1
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    // 结果小于0，左指针+1
                    l++;
                } else {
                    // 结果大于0，右指针-1
                    r--;
                }
            }
        }
        return resultList;
    }
}