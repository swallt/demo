package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 杨辉三角
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 */
public class leetcode118 {

    public static void main(String[] args) {
        int numRows = 4;
        List<List<Integer>> lists = generate(numRows);
        for (int i = 0; i<lists.size();i++){
            System.out.println(lists.get(i));
        }
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++){
                if (j==0 || j == i-1){
                    list.add(1);
                }else {
                    list.add(lists.get(i-2).get(j-1)+lists.get(i-2).get(j));
                }
            }
            lists.add(list);
        }
            return lists;
    }
}
