package com.zhousx.leetcode;

/**
 * 258 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class leetcode258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        int res = num;
        while (res % 10 !=  res){
            int temp = res;
            int cur = 0;
            while (temp % 10 != temp){
                cur += temp%10;
                temp /= 10;
            }
            cur += temp%10;
            res = cur;
        }
        return res;
    }
}
