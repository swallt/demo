package com.zhousx.demo;

import com.acquirer.util.DateUtil;

public class DateTest {
    public static void main(String[] args){
        String currDate = DateUtil.getCurrentTime24().substring(0,14);
        System.out.println(currDate);
    }
}
