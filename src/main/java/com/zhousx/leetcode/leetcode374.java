package com.zhousx.leetcode;

/**
 * 374 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class leetcode374 {
    public static void main(String[] args) {
        System.out.println(new leetcode374().guessNumber(10));
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = low + (high - low)/2;
        if(guess(n) == 0) return n;
        while (guess(mid) != 0){
            if (guess(mid) == -1){
                high = mid;
                mid = low + (high - low)/2 ;
            }else {
                low = mid;
                mid = low + (high - low)/2 + 1;
            }
        }
        return mid;
    }

    int guess(int num){
        int pick = 2;
        if (num == pick) return 0;
        return num > pick ? -1 : 1;
    }
}
