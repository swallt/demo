package com.zhousx.leetcode;

/**
 * 443 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 */
public class leetcode443 {

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(new leetcode443().compress(chars));
    }

    public int compress(char[] chars) {
        int res = 0,start = 0;
        while (start < chars.length){
            int end = start;
            while (end < chars.length && chars[end] == chars[start]){
                end++;
            }
            chars[res++] = chars[start];
            if (end - start > 1){
                String count = Integer.toString(end - start);
                for (int i = 0; i< count.length();i++){
                    chars[res++] = count.charAt(i);
                }
            }
            start = end;
        }
        return res;
    }
}
