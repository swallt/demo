package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class leetcode205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
    }
    public static boolean isIsomorphic(String s, String t) {
        //使用一个map建立s和t的对应关系，使用一个set来判断t中的重复字符，如果map中存在重复s的字符且t的字符不相等则返回false，如果不存在，
        //判断t的字符是否重复，不重复则存入map，否则返回false
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for (int i = 0;i<s.length();i++){
            if (map.containsKey(schar[i])){
                if (map.get(schar[i])!=tchar[i]){
                    return false;
                }
            }else {
                if (!set.add(tchar[i])){
                    return false;
                }
                map.put(schar[i],tchar[i]);
            }
        }
        return true;
    }
}
