package com.zhousx.leetcode;

/**
 * 198 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class leetcode198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        //简化动态规划
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0: nums[0];
        int[] res = new int[n];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for (int i =2; i<n;i++){
            res[i] = Math.max(res[i-1],nums[i]+res[i-2]);
        }
        return res[n-1];


        //动态规划
       /* int n = nums.length;
        if (n == 0){
            return 0;
        }
        //res【i】表示考虑抢劫nums【i...n-1】所能获得的最大收益
        int[] res = new int[n];
        //最简单的情况
        res[n-1] = nums[n-1];
        for (int i = n -2;i>=0;i--){
            //res【i】的取值再考虑抢劫i号房子和不考虑抢劫之间取最大值
            res[i] = Math.max(nums[i]+(i+2>= n?0:res[i+2]),nums[i+1]+(i+3>=n?0:res[i+3]));
        }
        return res[0];*/
       // 解法错误，隔1相加的和不一定是最大值
        /* if(nums.length==0){
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        }
        int i=0,j=1,max1=0,max2=0;
        while (i < nums.length){
            max1 += nums[i];
            i += 2;
        }
        while (j < nums.length){
            max2 += nums[j];
            j += 2;
        }
        return max1>max2 ? max1 : max2;*/
    }
}
