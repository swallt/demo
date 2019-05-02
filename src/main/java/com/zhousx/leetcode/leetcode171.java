package com.zhousx.leetcode;

import java.util.Arrays;

/**
 * 171 Excel表列序号
 * 给定一个excel表格中的裂名称，返回其相应的列序号
 *
 * 26进制转10进制
 */
public class leetcode171 {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int mix = 1;
        for (int i =chars.length-1; i >=0; i--){
            int num = chars[i]- 'A' + 1;
            result += num * mix;
            mix *= 26;
        }
        return result;
    }
}
