package com.zhousx.demo;

import com.acquirer.util.NumberStringUtil;

import java.text.DecimalFormat;

public class TransTest {
    public static String centToYuan(String amount){
        DecimalFormat df = new DecimalFormat("######0.00");
        Double d = Double.parseDouble(amount)/100;
        System.out.println(d);
        return df.format(d).toString();
    }
    
    public static void main(String[] args){
        System.out.println(centToYuan("0"));
        byte[] enterData = NumberStringUtil.hexStringToBytes("0D0A");
        System.out.println(enterData.length);
        byte[] enterData1 = new byte[0];
        System.out.println(enterData1.length);
        enterData1 = NumberStringUtil.hexStringToBytes("0D0A");
        System.out.println(enterData1.length);
        System.arraycopy(enterData,0,enterData1,0,enterData.length-2);
        System.out.println(enterData1.length);
    }
}


