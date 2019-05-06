package com.zhousx.leetcode;

import java.util.TreeSet;

/**
 * 202 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 示例:
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class leetcode202 {
    public static void main(String[] args) {
        System.out.println(isHappy(1737329854));
    }

    //双指针法  通过快慢指针，如果出现循环，快慢指针值会相等
    private static int callNext(int n){
        int res = 0;
        while (n != 0){
            res+=(n%10)*(n%10);
            n /= 10;
        }
        return res;
    }
    public static boolean ishappy(int n){
        int slow = n,fast =n;
        do {
            slow = callNext(slow);
            fast = callNext(fast);
            fast = callNext(fast);
        }while(slow != fast);
        return slow == 1;
    }

    private static boolean checkHappy(int n){
        char[] chars = String.valueOf(n).toCharArray();
        int count = 0;
        for (char c : chars){
            if (c == '1'){
                count++;
            }else if(c == '0'){
                continue;
            }else {
                count =9;
                break;
            }
        }
        if (count == 1){
            return true;
        }
        return false;
    }

    public static boolean isHappy(int n) {
        //执行运算后得到的数如果只包含一个1即可返回true，记录每次运算得到的数，如果出现重复，即可认为将进入死循环，程序结束并返回false
        TreeSet<Integer> ress= new TreeSet<>();

        while (true){
            if (checkHappy(n)){
                return true;
            }
            int res = 0;
            while (n != 0){
                res+=(n%10)*(n%10);
                n /= 10;
            }
            if (ress.contains(res)){
                break;
            }else{
                ress.add(res);
                n = res;
            }
        }
        return false;

        //需要考虑如何跳出死循环
        /*int sum =0;
        while (sum != 1){
            sum = 0;
            while (n > 0){
                sum += (n%10)*(n%10);
                n = n/10;
            }
            n = sum;
        }
        return true;*/
    }
    
}
