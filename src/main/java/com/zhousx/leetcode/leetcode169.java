package com.zhousx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 从第一个数开始计数，相同则加一，不同则减一，减到0就换一个数，得到最多的那个值
 */
public class leetcode169 {

    public int func(int[] nums){
        int count = 1;
        int res = nums[0];
        for (int i = 0; i< nums.length;i++){
            if (nums[i] == res) {
                count++;
            } else {
                count --;
                if (count == 0)
                    res = nums[i];
            }

        }
        return res;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i]) && map.get(nums[i])<=(nums.length/2)){
                int count = map.get(nums[i]) +1;
                map.put(nums[i],count);
            }else if (map.containsKey(nums[i]) && map.get(nums[i])> (nums.length/2)){
                return nums[i];
            } else {
                map.put(nums[i],1);
            }
        }
        return nums[0];
    }
}
