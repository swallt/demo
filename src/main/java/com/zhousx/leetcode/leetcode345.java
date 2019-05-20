package com.zhousx.leetcode;

/**
 * 345 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class leetcode345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length -1;
        while (low < high){
            if (!isVowels(chars[low])){
                low++;
            }
            if (!isVowels(chars[high])){
                high--;
            }
            if (isVowels(chars[low]) && isVowels(chars[high])){
                char temp = chars[low];
                chars[low] = chars[high];
                chars[high] = temp;
                low++;
                high--;
            }
        }
        return String.copyValueOf(chars);
    }

    private boolean isVowels(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
                || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }
}
