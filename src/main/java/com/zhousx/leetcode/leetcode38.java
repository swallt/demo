package com.zhousx.leetcode;

/**
 * 38 报数
 */
public class leetcode38 {
    public static void main(String[] args){
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n){
        String str = "1";
        for (int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j < str.length(); j++){
                int count = 0;
                int k;
                for (k = j;k < str.length(); k++){
                    if (str.charAt(j) != str.charAt(k)){
                        break;
                    }
                    count++;
                }
                sb.append(count).append(str.charAt(j));
                j = k - 1;
            }
            str = sb.toString();
        }
       return str;
      /*      while (n-- >1)
            str = findNext(str);
        return str;*/
    }
    private static String findNext(String str){
        StringBuilder sb = new StringBuilder();
        int i =0,j,count;
        while (i < str.length()){
            count = 0;
            for (j=i;j<str.length();j++){
                if (str.charAt(i) != str.charAt(j)){
                    break;
                }
                count++;
            }
            sb.append(count).append(str.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
