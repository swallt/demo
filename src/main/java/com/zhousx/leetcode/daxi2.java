package com.zhousx.leetcode;

public class daxi2 {
    public static void main(String[] args) {
        System.out.println(superDigit("9875",1));

    }

    public static int superDigit(String n,int k){
       StringBuilder p = new StringBuilder();
       while (k > 0){
           p.append(n);
           k--;
       }
       char[] chars = p.toString().toCharArray();
       long res = 0L;
       for (int i = 0 ; i<chars.length; i++){
           res += (chars[i] -'0');
       }
       //每次各位相加，其差值为9的倍数
       return res % 9 == 0 ? 9 : (int) (res % 9);
    }
}
