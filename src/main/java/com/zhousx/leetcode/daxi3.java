package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class daxi3 {

    public static void main(String[] args) {
        System.out.println(alternate("aaaaa"));

    }

    public static int alternate(String s){
        Set<String> cur = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        //获取字符串各字符出现次数
        for (int i = 0; i<chars.length; i++){
            if (map.containsKey(chars[i])){
                int temp = map.get(chars[i]) + 1;
                map.put(chars[i],temp);
            } else {
                map.put(chars[i],1);
            }
        }
        //寻找满足出现次数差值为0或1的两字符
        for (char a : map.keySet()){
            int aValue = map.get(a);
            for (char b : map.keySet()){
                if (a != b){
                    if ((aValue - map.get(b) == 0 )|| (aValue - map.get(b) == 1 ))
                        cur.add(a+""+b);
                }
            }
        }
        //寻找最长串的长度
        int maxlen = 0;
        for (String str : cur){
            int temp = func(str,s);
            maxlen = maxlen >= temp ? maxlen : temp;
        }
        return maxlen;
    }

    private static int func(String str,String s){
        StringBuilder sb = new StringBuilder();
        char a = str.charAt(0);
        char b = str.charAt(1);
        int len = 0;
        for (int i = 0; i<s.length();i++){
            if (s.charAt(i)==a || s.charAt(i)==b){
                sb.append(s.charAt(i));
                len++;
            }
        }
       if (sb.length() % 2 == 0){
            StringBuilder temp = sb.deleteCharAt(0);
            return temp.toString().equals(temp.reverse().toString()) ? len : 0;
       }
       return sb.toString().equals(sb.reverse().toString()) ? len : 0;
    }
}
