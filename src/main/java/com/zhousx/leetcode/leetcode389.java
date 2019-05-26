package com.zhousx.leetcode;

/**
 * 389 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class leetcode389 {

    public static void main(String[] args) {
        System.out.println(new leetcode389().findTheDifference("abcd","abdce"));
    }

    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char[] tchar = t.toCharArray();
        char[] schar = s.toCharArray();
        for (int i = 0; i<tchar.length; i++){
            arr[tchar[i] - 'a']++;
        }
        for (int i = 0; i<schar.length; i++){
            arr[schar[i] - 'a']--;
        }
        int i = 0;
        while (i < 26){
            if (arr[i] == 1)
                break;
            i++;
        }
        return (char) ('a'+i);
    }
}
