package com.zhousx.leetcode;

/**
 * 409 z最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class leetcode409 {

    public int longestPalindrome(String s) {
        int result = 0;
        boolean[] letters = new boolean[58];
        for (int i = 0;i<s.length(); i++){
            int index = s.charAt(i)-'A';
            if (letters[index]){
                letters[index] = false;
                result += 2;
            } else {
                letters[index] = true;
            }
        }

        return result == s.length() ? result : result + 1;
    }

   /* private int[] low = new int[26];
    private int[] upper = new int[26];

    public int longestPalindrome(String s) {

        if (s.length() < 2){
            return 0;
        }

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >='a' && s.charAt(i) <= 'z'){
                low[s.charAt(i)-'a']++;   //小写字母个数
            }else {
                upper[s.charAt(i)-'A']++;  //大写字母个数
            }
        }

        int res = 0;
        //统计大小写字母中数量大于2的
        for (int i =0;i<26;i++){
            if (low[i] > 1){
                if (low[i] % 2 == 0){
                    res += low[i];
                }else {
                    res += low[i] -1;  //数量为奇数时取最大偶数
                }
            }
            if (upper[i]>1){
                if (upper[i] % 2 == 0){
                    res += upper[i];
                }else {
                    res += upper[i] -1;
                }
            }
        }

        return res == 0 ? 0 : res + 1;
    }*/

    public static void main(String[] args) {
        System.out.println(new leetcode409().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
