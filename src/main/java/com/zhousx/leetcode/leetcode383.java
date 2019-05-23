package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 383 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class leetcode383 {

    public static void main(String[] args) {
        System.out.println(new leetcode383().canConstructNew("aa","aab"));
    }

    public boolean canConstructNew(String ransomNote, String magazine){
        int[] arr = new int[26];  //对应各字母

        for (char c : magazine.toCharArray()){
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            if (arr[c - 'a'] < 1){
                return false;
            }
            arr[c - 'a']--;
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> noteMap = new HashMap<>();
        Map<Character,Integer> magaMap = new HashMap<>();
        setMap(ransomNote,noteMap);
        setMap(magazine,magaMap);
        for (Character n: noteMap.keySet()){
            if (!(magaMap.containsKey(n) && noteMap.get(n)<=magaMap.get(n))){
                return false;
            }
        }
        return true;
    }

    private void setMap(String str,Map<Character,Integer> map){
        for (int i = 0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                int temp = map.get(str.charAt(i)) + 1;
                map.put(str.charAt(i),temp);
            }else {
                map.put(str.charAt(i),1);
            }
        }
    }
}
