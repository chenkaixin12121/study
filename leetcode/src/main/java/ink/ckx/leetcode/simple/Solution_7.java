package ink.ckx.leetcode.simple;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/13
 */
public class Solution_7 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2的31次方,  2的31次方 − 1] ，就返回 0。
     */
    public static void main(String[] args) {
        int num = 1234565479;
        System.out.println(new Solution_7().reverse(num));
    }

    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            // 避免溢出
            if (n < Integer.MIN_VALUE / 10 || n > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // x % 10 取出元素的个位数，123 % 10 = 3
            n = n * 10 + x % 10;
            // x / 10 去除元素的个位数，123 / 10 = 12
            x = x / 10;
        }
        return n;
    }
}