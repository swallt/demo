package com.zhousx.leetcode;

/**
 * 53 最大子序和
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组至少包含一个元素），返回其最大和。
 * 进阶：如果已经实现复杂度为O(n）的解法，尝试使用分治法求解
 */
public class leetcode53 {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){

        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = dp[i] > max ? dp[i] : max;
        }
        return max;

     /*   int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum > max){
                    max = sum;
                }
            }
            if (sum > max){
                max = sum;
            }
            sum = 0;
        }
        return max;*/
    }
}
