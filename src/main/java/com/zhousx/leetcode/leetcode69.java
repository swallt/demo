package com.zhousx.leetcode;

/**
 * 69 X 的平方根
 * 计算并返回X的平方根，其中x是非负整数
 * 返回结果只保留整数部分，小数部分将会舍去
 */
public class leetcode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(1024));
    }
    public static int mySqrt(int x){
       int low = 1;
       int high = x;
       while (low <= high){
           int mid = (high - low)/2 + low;
           int sqrt = x/mid;
           if (sqrt == mid){
               return mid;
           } else if (sqrt > mid){
               low = mid + 1;
           } else {
               high = mid -1;
           }
       }
       return high;
    }
}
