package com.zhousx.leetcode;

/**
 * 342 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 示例 1:
 * 输入: 16
 * 输出: true
 * 示例 2:
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class leetcode342 {

    public boolean isPowerOfFour(int num) {
        //判读是否是2的幂
        if(num <0 || (num & (num -1)) != 0){
            return false;
        }
        //如果是2的幂，只需判段除3是否余一
        return num % 3 ==1;
    }
}
