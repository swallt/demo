package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 412 Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class leetcode412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int cur = 1;
        while (cur <= n){
            if (cur % 3 == 0 && cur % 5 == 0){
                res.add("FizzBuzz");
            }else if (cur % 3 == 0){
                res.add("Fizz");
            }else if (cur % 5 == 0){
                res.add("Buzz");
            }else {
                res.add(cur+"");
            }
            cur++;
        }
        return res;
    }
}
