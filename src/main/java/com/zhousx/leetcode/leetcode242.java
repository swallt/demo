package com.zhousx.leetcode;

import java.util.Arrays;

/**
 * 242 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
public class leetcode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        int i = 0;
        while (i < chars.length){
            if (chars[i] != chart[i]){
                return false;
            }
            i++;
        }
        return true;
    }
}
