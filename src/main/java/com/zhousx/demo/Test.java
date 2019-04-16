package com.zhousx.demo;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args){
       /* System.out.println("hello git!");
        String balance = "20193896";//授权余额
        String sumUseAmt = "2248460900";//累计使用
        Long transAmtChnl = new Long(10000);//交易金额

        Long longBalance = new Long(balance);
        Long longSumUseAmt = new Long(sumUseAmt);
//        BigInteger bigBalance = new BigInteger(balance);
//        BigInteger bigSumUseAmt = new BigInteger(sumUseAmt);
        System.out.println(longBalance+transAmtChnl+"");
        System.out.println(longSumUseAmt - transAmtChnl + "");*/
//       System.out.println(BigInteger.valueOf(80_000));

      /* zz();

        final String zz = "ssd";
        for (int i = 0; i < 2; i++) {
//            String zz = i+"";
            System.out.println(zz);
        }*/
      String s1 = "hello";
      String s2 = "world";
      System.out.println(s1 + "----" + s2);
      change(s1,s2);
      System.out.println(s1 + "----" + s2);
      
      StringBuffer sb1 = new StringBuffer("hello");
      StringBuffer sb2 = new StringBuffer("world");
      System.out.println(sb1 + "--" + sb2);
      change(sb1,sb2);
      System.out.println(sb1 + "--" + sb2);
    }
    public static void zz(){
        final String zz = "fianlzz";
        System.out.println(zz);
    }

    public static void change(StringBuffer sb1, StringBuffer sb2){
        sb1 = sb2;
        sb2.append(sb1);
    }

    public static void change(String s1, String s2){
        s1 = s2;
        s2 = s1 + s2;
        System.out.println(s1+"11"+s2);
    }
}
