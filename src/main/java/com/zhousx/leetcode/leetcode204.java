package com.zhousx.leetcode;

import java.util.Arrays;

/**
 * 204 计算质数
 * 统计所有小于非负整数n的质数的数量
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class leetcode204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }

    public static int countPrimes(int n) {
        //厄拉多塞筛法
        if (n < 3)
            return 0;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        //0 ,1 不是质数，所以列表的前两个位置赋值为0
        arr[0] = 0;
        arr[1] = 0;
        int cnt = n -2;
        //从(2,int(n**0.5)+1)而非(2,n).这个技巧是可以验证的,比如说求9以内的质数个数,那么只要划掉sqrt(9)以内的质数倍数,
        //剩下的即全为质数. 所以在划去倍数的时候也是从i*i开始划掉,而不是i+i.
        for (int i = 2; i<= Math.sqrt(n); i++){
            if (arr[i] == 1){
                for (int j = 2;j*i<n;j++){
                    if (arr[i*j]==1){
                        arr[i*j] =0;
                        cnt--;
                    }
                }
            }
        }
        return cnt;

        //大数计算时间过长
       /* int count = 0;
        n = n-1;
        while (n>1){
            int i = 2;
            while (i<=n){
                if ((n%i==0)&&(n/i!=1)){
                    break;
                }else if (i == n){
                    count++;
                }
                i++;
            }
            n--;
        }
        return count;*/
    }
}
