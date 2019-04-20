package com.zhousx.leetcode;

import java.util.*;

/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，需要在原始数组上删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不使用额外的数组空间
 */
public class leetcode26 {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,3,4,4,4,5,6,6,6,7,7,7};
        int a = removeDuplicates(nums);
        System.out.println("去重后长度为： " + a);
    }
    
 /*   public static int removeDuplicates(int[] nums){
        int len = 0;
        if (nums.length == 0)
            return len;
        int min = Integer.MIN_VALUE;
        for (int i =0; i<nums.length; i++){
            if (min != nums[i]){
                min = nums[i];
                nums[len] = nums[i];
                System.out.println(nums[len]);
                len++;
            }
        }
        return len;
    }*/
    /**
     * 最少耗时
     */
    public static int removeDuplicates(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        Set<Integer> set = map.keySet();
        Iterator it = set.iterator();
            int t=0;
            while (it.hasNext()){
                int i = (int) it.next();
                nums[t] = i;
                t++;
            }

        Arrays.sort(nums,0,t);
        return map.size();
    }
}
