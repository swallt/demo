package com.zhousx.leetcode;

/**
 * 387 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class leetcode387 {

    public static void main(String[] args) {
        System.out.println(new leetcode387().firstUniqChar("loveleetcode"));
    }
    
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (Character c : s.toCharArray()){
            arr[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                res = res < s.indexOf((char)(i + 'a')) ? res : s.indexOf((char)(i + 'a'));
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
