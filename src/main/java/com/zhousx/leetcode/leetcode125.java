package com.zhousx.leetcode;

/**
 * 125 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中空字符串也为有效的回文串。
 */
public class leetcode125 {
    public static void main(String[] args) {
        System.out.println(isPalindromeFast("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s){
        if (s == null){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        String news = s.toLowerCase();
        for (int i = 0;i<news.length();i++){
            if ((news.charAt(i)>='a'&&news.charAt(i)<='z')||Character.isDigit(news.charAt(i)))
                sb.append(news.charAt(i));
        }
        String trueS = sb.toString();
        for (int i = 0;i<trueS.length()/2;i++){
            if (trueS.charAt(i) != trueS.charAt(trueS.length()-1-i))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeFast(String s){
        //双指针法
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length -1;
        while (start<end){
            char ch1 = chars[start];
            if (!((ch1>='A'&&ch1<='Z')||
                    (ch1>='a'&&ch1<='z')||
                    (ch1>='0'&&ch1<='9'))){
                start++;
                continue;
            }
            char ch2 = chars[end];
            if (!((ch2>='A'&&ch2<='Z')||
                    (ch2>='a'&&ch2<='z')||
                    (ch2>='0'&&ch2<='9'))) {
                end--;
                continue;
            }
            if ((ch1 - ch2)==0 || Math.abs(ch1-ch2)==32){
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
