package com.zhousx.leetcode;

/**
 * 70 爬楼梯
 * 假设你正在爬楼梯。需要n阶才能到达楼顶
 * 每次你可以爬1或2个台阶，有多少种不同的方法可以到达楼顶。
 *
 * 斐波那契数列，从第三位开始
 * F（n）=F（n-1）+F（n-2）
 */
public class leetcode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n){
        if (n <= 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else{
            int a=1,b=2,c=0;
            for (int i = 3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }
}
