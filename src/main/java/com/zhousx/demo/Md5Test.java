package com.zhousx.demo;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zhousx.util.MD5SignUtil;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Map;

public class Md5Test {
    public static String md5(String password, String salt){
        return new Md5Hash(password,salt,2).toString();
    }
    public static void main(String[] args) throws Exception{

        Gson gson = new Gson();
        String msgAsc = "{\"tradeId\":\"01423050201811271537091369257651\",\"channelNo\":\"TK\",\"balunitNo\":\"SH000003\",\"deviceNo\":\"TKLCKJSK000000000000000000000001\",\"termNo\":\"351000000001\",\"asn\":\"03104830301611163806\",\"cardType\":\"S1\",\"rndNumber2\":\"09E5179B\",\"cardTradeNo\":\"0000\",\"tradeType\":\"02\",\"keyVersion\":\"01\",\"arithIndex\":\"00\",\"mac1\":\"151DC7D9\",\"hostDate\":\"20181127\",\"hostTime\":\"153709\",\"paymentType\":\"01\",\"accountNo\":\"01\",\"paymentTradeId\":\"01\",\"operateMode\":\"02\",\"cardOldBal\":0,\"tradeMoney\":1}";
        JsonObject jsonObject = gson.fromJson(msgAsc,JsonObject.class);
        Map<String, String> map = gson.fromJson(jsonObject.toString(),new TypeToken<Map<String,String>>(){}.getType());
        String keyValue = "6b9fd953-5ec9-4162-9b75-22517d6466dd";
        String sign = MD5SignUtil.genPackageSign(map, keyValue, "utf-8");
        System.out.println(sign);
    }


}
