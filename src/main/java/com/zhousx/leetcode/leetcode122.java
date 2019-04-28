package com.zhousx.leetcode;

/**
 * 122 买卖股票的最佳时间
 * 给定一个数组，他的第i个元素是一支给定股票第i天的价格
 * 设计一个算法来计算你所能获取的最大利润，你可以尽可能地完成更多的交易（多次买卖一支股票）
 * 不能同时参与多笔交易（必须在再次购买前出售掉之前的股票）
 */
public class leetcode122 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitEasy(prices));
    }

    public static int maxProfitEasy(int[] prices){
        //提取峰谷法的思路，只要后一个值比前一个值大即累计利润
        int maxProfit = 0;
        for (int i =1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices){
        //遍历所有可能的交易，找出最大利润值
//        return func(prices,0);

        //峰谷 通过寻找连续的峰和谷，即可求出最大利润
        int i = 0;
        int low = prices[0];
        int high = prices[0];
        int maxProfit = 0;
        while (i<prices.length-1){
            while (i<prices.length -1 && prices[i]>=prices[i+1])
                i++;
            low = prices[i];
            while (i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            high = prices[i];
            maxProfit += high - low;
        }
        return maxProfit;
    }


    private static int func(int[] prices,int s){
        if (s >= prices.length){
            return 0;
        }
        int max = 0;
        for (int i = s; i < prices.length;i++){
            int maxProfit = 0;
            for (int j = i+1; j < prices.length; j++){
                if (prices[i]<prices[j]){
                    int profit = func(prices,j+1)+prices[j]-prices[i];
                    if (profit > maxProfit){
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max)
                max = maxProfit;
        }
        return max;
    }
}
