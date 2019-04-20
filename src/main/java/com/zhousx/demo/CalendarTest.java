package com.zhousx.demo;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args){
/*        Date dateCurrent = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        calendar.setTime(dateCurrent);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        
//        System.out.println(format.format(calendar.getTime()));
//        System.out.println(dateCurrent);
//        System.out.println(new Random().nextInt(10000000-999999)+999999);

        String checkAccDate = DateUtil.date2Stringyyyymmddhhmmss(DateUtil.addDay(new Date(), -1)).substring(0, 8);
        System.out.println(checkAccDate);*/

        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH,1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = d.getFirstDayOfWeek();

        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i =1; i<=indent; i++)
            System.out.println("  ");

        d.set(Calendar.DAY_OF_MONTH, 1);
        do{
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if (day==today) 
                System.out.print("*");
            else System.out.print(" ");
            
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek) System.out.println();
        } while (d.get(Calendar.MONTH) == month);
        
        if (weekday != firstDayOfWeek) System.out.println();
    }

}
