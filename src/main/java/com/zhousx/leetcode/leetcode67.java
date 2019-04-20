package com.zhousx.leetcode;

/**
 * 67 二进制求和
 * 给定两个二进制字符串，返回他们的和（二进制表示）
 * 输入非空字符串且只包含数字1和0
 */
public class leetcode67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1111","1111"));
    }
    public static String addBinary(String a,String b) {
        if (a.length() > b.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            for (int i = 0; i < a.length() - b.length(); i++) {
                sb.insert(0, "0");
            }
            b = sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            for (int i = 0; i < b.length() - a.length(); i++) {
                sb.insert(0, "0");
            }
            a = sb.toString();
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int pa = aChars.length - 1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (pa >= 0) {

            if (aChars[pa] != bChars[pa] && sum == 0) {
                sb.insert(0, "1");
                pa--;
                sum = 0;
            } else if (aChars[pa] != bChars[pa] && sum == 1) {
                sb.insert(0, "0");
                pa--;
                sum = 1;
            } else if (Integer.valueOf(aChars[pa])+Integer.valueOf(aChars[pa])+sum ==96){
                sb.insert(0,"0");
                pa--;
                sum = 0;
            } else if (Integer.valueOf(aChars[pa])+Integer.valueOf(aChars[pa])+sum ==97){
                sb.insert(0,"1");
                pa--;
                sum = 0;
            } else if (Integer.valueOf(aChars[pa])+Integer.valueOf(aChars[pa])+sum ==98) {
                sb.insert(0,"0");
                pa--;
                sum = 1;
            } else {
                sb.insert(0,"1");
                pa--;
                sum = 1;
            }
        }
        if (sum == 1){
            sb.insert(0,"1");
        }
        return sb.toString();
    }
}
