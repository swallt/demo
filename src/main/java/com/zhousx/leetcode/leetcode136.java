package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 136 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 *
 * 利用异或的计算特性：
 *  1、交换律： a^b^c <=> a^c^b
 *  2、任何数与0异或为任何数: 0^n => n
 *  3、相同的树异或为0： n^n => 0
 */
public class leetcode136 {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int r = 0;
        for (int i : nums){
            r = r ^ i;
        }
        return r;

        /*List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length -1){
            if (list.contains(nums[i])){
                i++;
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    list.add(nums[i]);
                    i++;
                    break;
                } else if(nums[i] != nums[j] && j == nums.length-1){
                    return nums[i];
                }
            }
        }
        return nums[i];*/
    }
}
