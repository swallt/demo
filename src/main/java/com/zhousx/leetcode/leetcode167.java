package com.zhousx.leetcode;

/**
 *  167 两数之和 - 输入有序数组
 *  给定一个已按照升序排列的有序数组，找到两个数使得他们相加之和等于目标数
 *  函数应该返回这俩个数的下标index1和index2，其中index1必须小于index2
 *  说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 */
public class leetcode167 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(numbers,target).toString());
    }

    public static int[] twoSum(int[] numbers, int target) {

        int low = 0,high = numbers.length-1;
        while (low < high){
            if ((numbers[low]+numbers[high]) == target){
                return new int[]{low + 1,high +1};
            }else if ((numbers[low]+numbers[high]) < target){
                low++;
            } else {
                high--;
            }
        }
        return null;

        /*int mid = target >> 1;
        int i = 0;
        while (numbers[i] < mid){
            i++;
        }
        int index1 = i-1;
        int index2 = i;
        if (index1 < 0){
            if ((numbers[0]+numbers[1]) == target){
                return new int[]{1,2};
            }
        }
        while (index1 >= 0 & index2 < numbers.length & (numbers[index1] + numbers[index2]) != target) {
            if (numbers[index1] + numbers[index2] > target) {
                index1--;
            } else {
                index2++;
            }
        }
        return new int[]{index1 + 1, index2 + 1};*/
    }
}
