package com.zhousx.leetcode;

/**
 * 371 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class leetcode371 {

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }
    
    public static int getSum(int a, int b) {
        int sum = a ^ b;  //忽略进位，各二进制位相加
        int carry = (a & b) << 1; //获得进位
        if (carry != 0){
            sum = getSum(sum,carry);
        }
        return sum;
    }
}
