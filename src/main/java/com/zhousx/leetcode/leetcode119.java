package com.zhousx.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 119 杨辉三角Ⅱ
 * 给定一个非负索引k，且k<34，返回杨辉三角的第k行。
 */
public class leetcode119 {

    public static List<Integer> getRow(int rowIndex){
        Integer[] dp = new Integer[rowIndex+1];
        Arrays.fill(dp,1);
        for (int i = 2; i< dp.length; i++){
            for (int j = i -1; j>0; j--){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }
}
