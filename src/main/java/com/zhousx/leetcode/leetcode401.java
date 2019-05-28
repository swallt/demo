package com.zhousx.leetcode;

import java.util.*;

/**
 * 401 二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，上面的二进制手表读取 “3:25”。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 案例:
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 注意事项:
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 */
public class leetcode401 {

    private Map<Integer,List<String>> map = new HashMap<>();

    public List<String> readBinaryWatch(int num) {
        if (map.size() == 0){
            for (int i = 0;i<12;i++){
                for (int j =0; j<60; j++){
                    if (map.containsKey(count1(i)+count1(j))){
                        map.get(count1(i)+count1(j)).add(i + ":" + (j < 10 ? "0" + j : j));
                    } else {
                        List<String> list = new LinkedList<>();
                        list.add(i + ":" + (j < 10 ? "0" + j : j));
                        map.put(count1(i)+count1(j),list);
                    }
                }
            }
            return  null == map.get(num) ? new ArrayList<>() : map.get(num);
        }
        return  null == map.get(num) ? new ArrayList<>() : map.get(num);
    }

    private int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
