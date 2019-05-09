package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219 存在重复元素Ⅱ
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 这个翻译我真是服了
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class leetcode219 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            if (map.containsKey(nums[i])){
                if (i-map.get(nums[i])<=k){
                    return true;
                }
                map.put(nums[i],i);
            } else {
                map.put(nums[i],i);
            }
        }
        return false;

        /*for (int i =0;i<nums.length-k;i++){
            if (nums[i] == nums[i+k]){
                for (int j = i+k+1;j<nums.length;k++){
                    if (nums[j] == nums[i]){
                        break;
                    }
                }
                return true;
            }
        }
        return false;*/
    }
}
