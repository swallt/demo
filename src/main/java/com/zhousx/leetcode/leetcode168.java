package com.zhousx.leetcode;

/**
 * 168 Excel表列名称
 * 给定一个正整数，返回它在Excel表中相应的列名称
 *
 * 十进制转26进制
 * 65 = A
 */
public class leetcode168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }

    public static String convertToTitle(int n){
        StringBuffer stringBuffer = new StringBuffer();
        while (n > 0){
            n--;
            char a = (char) (n % 26 + 65);
            stringBuffer.insert(0,a);
            n /= 26;
        }
        return stringBuffer.toString();
    }
}
