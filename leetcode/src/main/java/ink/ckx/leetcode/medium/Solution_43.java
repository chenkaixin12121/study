package ink.ckx.leetcode.medium;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/15
 */
public class Solution_43 {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "15";
        System.out.println(new Solution_43().multiply(num1, num2));
    }

//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        String result = "0";
//        // 从个位开始遍历num2的每一位，跟num1相乘，并叠加计算结果
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            // 取出num2的当前数位，作为当前乘法的第二个乘数
//            int n2 = num2.charAt(i) - '0';
//            // 保存乘积结果
//            StringBuilder curResult = new StringBuilder();
//            // 保存进位
//            int carry = 0;
//            // 补0,补n-1-i个0
//            for (int j = 0; j < num2.length() - 1 - i; j++) {
//                curResult.append("0");
//            }
//            // 从个位开始遍历num1中的每一位，与n2相乘，并叠加
//            for (int j = num1.length() - 1; j >= 0; j--) {
//                // 取出num1的当前数位，作为当前乘法的第一个乘数
//                int n1 = num1.charAt(j) - '0';
//                // 计算当前数位的乘积结果
//                int product = n1 * n2 + carry;
//
//                curResult.append(product % 10);
//                carry = product / 10;
//            }
//            // 如果剩余进位
//            if (carry != 0) {
//                curResult.append(carry);
//            }
//            result = addStrings(result, curResult.reverse().toString());
//        }
//        return result;
//    }
//
//    public String addStrings(String num1, String num2) {
//        int i = num1.length() - 1;
//        int j = num2.length() - 1;
//        int add = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i >= 0 || j >= 0 || add != 0) {
//            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
//            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
//            int result = x + y + add;
//            sb.append(result % 10);
//            add = result / 10;
//            i--;
//            j--;
//        }
//        return sb.reverse().toString();
//    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果的每一位
        int[] resultArray = new int[num1.length() + num2.length()];
        // 遍历num1和num2的每一位，做乘积
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 计算乘积
                int product = n1 * n2;
                // 保存
                int sum = product + resultArray[i + j + 1];
                // 叠加结果的个位保存到i+j+1位置
                resultArray[i + j + 1] = sum % 10;
                resultArray[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 如果最高位是0，则从1开始遍历
        int start = resultArray[0] == 0 ? 1 : 0;
        for (int i = start; i < resultArray.length; i++) {
            sb.append(resultArray[i]);
        }
        return sb.toString();
    }
}
