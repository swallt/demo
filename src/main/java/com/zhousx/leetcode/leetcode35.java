package com.zhousx.leetcode;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引值。如果目标值不存在于数组中，返回它将会被按顺序插入的索引值
 */
public class leetcode35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 6;
        System.out.println("args = [" + searchInsert(nums,target) + "]");
    }

    public static int searchInsert(int[] nums,int target){
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                index = i;
                return index;
            } else if (nums[i] > target){
                index = i;
                return index;
            } else {
                index = i ;
            }
        }
        return index + 1;
    }
}
