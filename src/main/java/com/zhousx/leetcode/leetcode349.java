package com.zhousx.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 349 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class leetcode349 {
    public static void main(String[] args) {
       int[] nums1 = {};
       int[] nums2 = {};
       int[] res = intersection(nums1,nums2);
       for (int i =0;i<res.length;i++ ){
           System.out.println(res[i]);
       }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<nums1.length; i++){
            set.add(nums1[i]);
        }
        for (int i = 0;i<nums2.length; i++){
            set2.add(nums2[i]);
        }
        for (Integer i : set2){
            if (!set.add(i)){
                sb.append(i+",");
            }
        }
        if (sb.length() == 0){
            return new int[]{};
        }
        String[] s = sb.toString().split(",");
        int[] res = new int[s.length];
        int cur = 0;
        while (cur < s.length){
            res[cur] = Integer.valueOf(s[cur]);
            cur++;
        }
        return res;
    }
}
