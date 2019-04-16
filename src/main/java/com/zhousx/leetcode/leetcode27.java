package com.zhousx.leetcode;

/**
 * 移除元素
 * 给定一个数组nums和一个值val，需要原地移除所有数值等于val的元素，返回移除后数组的新长度
 * 不要使用额外的数组空间
 * 元素的顺序可以改变，不需要考虑数组中超出新长度后面的元素。
 */
public class leetcode27 {
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val =2;
        System.out.println(removeElement(nums,val));
    }

    public static int removeElement(int[] nums, int val){
        int len = 0;
        if (nums.length == 0){
            return len;
        }
        for (int i =0; i<nums.length; i++){
            if (val != nums[i]){
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
