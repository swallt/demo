package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 290 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class leetcode290 {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern,str));
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character,String> cur = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (chars.length != strings.length)
            return false;
        int i = chars.length - 1;
        while (i>=0){
            if (cur.containsKey(chars[i])){
                if (cur.get(chars[i]).equals(strings[i])){
                    i--;
                    continue;
                }else {
                    return false;
                }
            } else {
                if (cur.containsValue(strings[i]))
                    return false;
                cur.put(chars[i],strings[i]);
                i--;
            }
        }
        return true;
    }
}
