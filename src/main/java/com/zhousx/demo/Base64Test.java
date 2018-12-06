package com.zhousx.demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Test {
    public static void main(String[] args) throws IOException {
        String str = "9RuSWa9qBLuvx23DzRGU37AbOOFL9VRS3ttLxuGfzaP=";
        int len = str.length() & 0xFFFFFFFE;
        System.out.println(len);
        BASE64Decoder decoder = new BASE64Decoder();
        String str1 = new String(decoder.decodeBuffer(str), "UTF-8");
        int len1 = str1.length() & 0xFFFFFFFE;
        System.out.println( new String(decoder.decodeBuffer(str), "UTF-8"));
        System.out.println(len1);
       /* BASE64Encoder encode = new BASE64Encoder();
        try {
            String str = encode.encode(new String("9RuSWa9qBLuvx23DzRGU37AbOOFL9VRS3ttLxuGfzaP=").getBytes("utf-8"));
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
   /*     try {
            BASE64Decoder decoder = new BASE64Decoder();
            String src = "9RuSWa9qBLuvx23DzRGU37AbOOFL9VRS3ttLxuGfzaP=";
            try {
                final byte[] bytesrc = decoder.decodeBuffer(src);
                System.out.println(new String(bytesrc));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
