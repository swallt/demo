package com.zhousx.leetcode;

/**
 * 400 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 示例 1:
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class leetcode400 {

    public static void main(String[] args) {
        System.out.println(new leetcode400().findNthDigit(400));
    }

    public int findNthDigit(int n) {
        n--;
        int first =1,digits = 1;
        // 1-9/10-99/100-999/1000-9999/10000
        while (n/9/first/digits >= 1){
            n-= 9*first*digits;
            digits++;
            first *= 10;
        }

        return (first + n/digits +"").charAt(n%digits)-'0';
    }
}
