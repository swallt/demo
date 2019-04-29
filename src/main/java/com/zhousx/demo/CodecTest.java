package com.zhousx.demo;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CodecTest {

    public static void main(String[] args){

        //MD5
        String str = "abc";
        System.out.println("MD5: "+DigestUtils.md5Hex(str));

        //SHA1
        System.out.println("SHA1: "+DigestUtils.sha1Hex(str));

        //BASE64加密
        byte[] b = Base64.encodeBase64(str.getBytes(),true);
        System.out.println(new String(b));

        //BASE64解密
        String str1 = "YWJj";
        byte[] b1 = Base64.decodeBase64(str1.getBytes());
        System.out.println(new String(b1));
    }

}
