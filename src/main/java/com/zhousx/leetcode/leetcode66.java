package com.zhousx.leetcode;

/**
 * 66 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
 * 最高位数字存放在数组首位，数组中每个元素只存储一个数字。
 */
public class leetcode66 {
    public static void main(String[] args){
        int[] ints = {9};
        ints = plusOne(ints);
        for (int x : ints){
            System.out.println(x);
        }
    }

    public static int[] plusOne(int[] digits){
        int add = 0;
        int l = digits.length -1;

        while (add == 0 && l >= 0){
            if (digits[l] == 9){
                digits[l] = 0;
                l --;
            } else {
                digits[l] = digits[l] + 1;
                add = 1;
            }
        }
        if (l== -1 && add == 0){
            int[] digitsNew = new int[digits.length+1];
            digitsNew[0] = 1;
            System.arraycopy(digits,0,digitsNew,1,digits.length);
            return digitsNew;
        }else {
            return digits;
        }
    }
}
