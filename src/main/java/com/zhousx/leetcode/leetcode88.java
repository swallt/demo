package com.zhousx.leetcode;


/**
 * 88 合并两个有序数组
 * 给定两个有序数组nums1、nums2，将nums2合并到nums1中
 *  初始化nums1和nums2的长度分别是m、n
 *  可以假设nums1有足够的空间存储两个数组的元素
 *  解法：逆序遍历,需要考虑m与n的大小关系
 */
public class leetcode88 {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m =0,n=1;
        merge(nums1,m,nums2,n);
    }

    public static void merge(int[] nums1,int m,int[] nums2, int n){
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0){
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n>=0){
            nums1[p--] = nums2[n--];
        }
        for (int i =0; i< nums1.length; i++){
            System.out.print(nums1[i]+",");
        }
    }
}
