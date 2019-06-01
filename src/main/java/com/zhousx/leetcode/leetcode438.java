package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438 找到字符串中所有的字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class leetcode438 {

    public static void main(String[] args) {
        System.out.println(new leetcode438().findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int i = 0,j=p.length();
        if (s.length() < j){
            return new ArrayList<Integer>();
        }
        while (i+j <= s.length()){
            if (func(s.substring(i,i+j),p)){
                res.add(i);
            }
            i++;
        }
        return res;
    }

    private boolean func(String s,String p){
        int[] cur = new int[26];
        for (int i = 0; i< s.length(); i++){
            cur[s.charAt(i)-'a']++;
            cur[p.charAt(i)-'a']--;
        }
        for (int i : cur){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
