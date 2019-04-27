package com.zhousx.leetcode;

/**
 * 121 买卖股票的最佳时机
 * 给定一个数组，它的第i个元素是一支给定股票第i天的价格
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获得的最大利润
 * 注意不能在买入股票前卖出股票
 *
 * 分快慢指针循环遍历数组，快指针减去慢指针的最大差值即最大利润
 */
public class leetcode121 {

    public static int maxProfit(int[] prices){
        int max = 0;
        for (int i = 0;i<prices.length-1;i++){
            for (int j = i+1; j < prices.length; j++){
                if (prices[j]-prices[i]>max){
                    max = prices[j]- prices[i];
                }
            }
        }
        return max;
    }

    // 一次循环即可，当遍历值小于最小值就更新最小价格，当遍历值大于最小值且差大于最大利润则更新最大利润
    public static int better(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int max = 0;
        for (int i= 0; i< prices.length;i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if (prices[i]-minprice>max){
                max = prices[i] - minprice;
            }
        }
        return max;
    }
}
