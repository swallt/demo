package com.zhousx.leetcode;

/**
 * 58 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格的字符串，返回其最后一个单词的长度
 */
public class leetcode58 {
    public static void main(String[] args){
//        String str = "a   ";
        String str = "h world";
        System.out.println(lengthOfLastWord(str));
    }
    
    public static int lengthOfLastWord(String str){
        if (str == null ||str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = 0;
        int flag = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == ' '){
                flag = 1;
            }else if(chars[i] != ' ' && flag == 0) {
                len++;
            }else if(chars[i] != ' ' && flag == 1){
                len = 1;
                flag = 0;
            }
        }
        return len;
    }
}
