package com.zhousx.leetcode;

/**
 * 28. 实现strStr()
 * 给定两个字符串，找出一个字符串在另一个字符串中出现的第一个位置，如果不存在，则返回 -1
 * 当被条件字符串是空字符串时返回0，这与c中对的strstr()以及java中的indexOf() 定义相符
 */
public class leetcode28 {
    public static void main(String[] args){
        System.out.println(strStr("a","a"));
    }

    public static int strStr(String haystack,String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        if (hay.length == nee.length) {
            for (int i = 0; i < hay.length; i++) {
                if (hay[i] != nee[i]) {
                    return -1;
                }
            }
            return 0;
        } else {
            for (int i = 0; i <= hay.length - nee.length; i++) {
                boolean flag = true;
                for (int j = 0; j < nee.length; j++) {
                    if (hay[i + j] != nee[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
}
