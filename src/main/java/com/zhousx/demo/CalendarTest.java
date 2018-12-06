package com.zhousx.demo;

import com.acquirer.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CalendarTest {
    public static void main(String[] args){
        Date dateCurrent = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        calendar.setTime(dateCurrent);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        
//        System.out.println(format.format(calendar.getTime()));
//        System.out.println(dateCurrent);
//        System.out.println(new Random().nextInt(10000000-999999)+999999);

        String checkAccDate = DateUtil.date2Stringyyyymmddhhmmss(DateUtil.addDay(new Date(), -1)).substring(0, 8);
        System.out.println(checkAccDate);
    }

}
