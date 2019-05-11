package com.zhousx.leetcode;

/**
 * 231 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 */
public class leetcode231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(33));
    }

    public static boolean isPowerOfTwo(int n) {

        //2的幂次方的二进制只有一位是1， 它与自己的负数相与得到本身
        return (n>0)&&((n & -n)==n);

       /* if (n <= 0)
            return false;
        if (n == 1)
            return true;
        while (n > 2 ){
            if (n%2 != 0){
                return false;
            }
             n = n >>1;
        }
        return true;*/
    }
}
