package com.zhousx.leetcode;

/**
 * 459 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class leetcode459 {

    public static void main(String[] args) {
        System.out.println(new leetcode459().repeatedSubstringPattern("babbabbabbabbab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = 1;
        while (len <= s.length() / 2) {
            if (s.length() % len != 0) {
                len++;
            } else {
                String cur = s.substring(0, len);
                for (int i = len; i + len <= s.length(); i += len) {
                    if (!s.substring(i, i + len).equals(cur)) {
                        len++;
                        break;
                    }
                    if (i + len == s.length() && s.substring(i, i + len).equals(cur)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
