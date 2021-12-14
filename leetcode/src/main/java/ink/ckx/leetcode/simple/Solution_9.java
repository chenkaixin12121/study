package ink.ckx.leetcode.simple;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/13
 */
public class Solution_9 {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     */
    public static void main(String[] args) {
        int x = 12321;
        System.out.println(new Solution_9().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        // 如果 x < 0，则说明是负数，负数不是回文数
        // 如果 x % 10 == 0，说明 x 的个位数是0，反转后也不是回文数
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int n = 0;
        // 反转一半的元素，对于双数 length / 2，单数 (length / 2) + 1
        while (x > n) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        // 12121，x = 12, n = 121
        // 1221, x = 12, n = 12
        return x == n || x == n / 10;
    }
}