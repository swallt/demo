package com.zhousx.demo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.acquirer.util.NumberStringUtil;
import com.alibaba.dubbo.common.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonTest {
    public static void main(String[] args){
//        String recvData = "{\"addSystem\":\"2010\",\"currctNum\":0,\"customInfo\":\"00-50-56-C0-00-08&221.167.254.100\",\"msgMac\":\"0\",\"msgVer\":\"10\",\"recordNum\":1,\"resultCode\":0,\"resultInfo\":\"验证通过\",\"srcSystem\":\"1010\",\"totalNum\":0,\"tradeData\":[{\"terminalId\":\"413101371845\",\"token\":\"duSE3URaPRSJxa3Xqh7UKLdoPabhTRJeBeS2O2tb9LP=\",\"vector\":\"JD/5rhoLGUKeGDKCJhqvrq==\"}],\"tradeType\":2000}";
 /*       Map<String, String> parameters = new HashMap<String, String>();
        String reqMsgBody="";
        try {
            reqMsgBody = new String(
                    NumberStringUtil.hexStringToBytes(recvData), "utf-8");
            Gson gson = new Gson();
            parameters = gson.fromJson(reqMsgBody,Map.class);
            System.out.println(parameters);
        } catch (UnsupportedEncodingException e) {
        }*/
    /*    JsonObject jsonObject = new JsonParser().parse(recvData).getAsJsonObject();
        System.out.println(jsonObject);
        String msgMac = jsonObject.get("msgMac").toString();
        System.out.println(jsonObject.get("currctNum").getAsString());
        System.out.println(msgMac);
        JsonArray jsonArray = jsonObject.getAsJsonArray("tradeData");
        System.out.println(jsonArray);
        System.out.println(jsonArray.toString().replaceAll("\\[","").replaceAll("\\]",""));*/
        String recvData ="{\"respCode\":\"40001\",\"respDsc\":\"充值成功\",\"mac2\":\"AC73EF1F\"}";
        try {
            String str1 = NumberStringUtil.bytesToHexString((recvData).getBytes("UTF-8"));
            System.out.println(str1);
            byte[] mybyte = NumberStringUtil.hexStringToBytes(str1);
            System.out.println(mybyte);
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new String(mybyte,"UTF-8"),JsonObject.class);
//            String str2 = new String(
//                    NumberStringUtil.hexStringToBytes(str1),
//                    "UTF-8");
//            JsonObject jsonObject = new JsonParser().parse(str2).getAsJsonObject();
            System.out.println(jsonObject);
//            System.out.println(jsonObject.get("currctNum").getAsString());
//            JsonArray jsonArray = jsonObject.getAsJsonArray("tradeData");
//            System.out.println(jsonArray);
//            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        String fileData = "062E001F001FB20000E80300000B413100759723201807231549546923000000000000000000000000000000000000009000";
//        System.out.println(fileData.substring(0,62));
//        System.out.println(NumberStringUtil.addLeftZero("00", 36));

       /* String jsonstr = "{\"tradeId\":\"01423050201810301100281134986544\",\"channelNo\":\"01\",\"balunitNo\":\"CS000002\",\"deviceNo\":\"ABCD0000000000000000000000000001\",\"termNo\":\"013376061930\",\"asn\":\"03104830399999990005\",\"cardType\":\"S1\",\"rndNumber2\":\"9C92B2C2\",\"cardTradeNo\":\"0001\",\"tradeType\":\"02\",\"keyVersion\":\"01\",\"arithIndex\":\"00\",\"mac1\":\"F13FCC14\",\"hostDate\":\"20181030\",\"hostTime\":\"161056\",\"paymentType\":\"01\",\"accountNo\":\"01\",\"paymentTradeId\":\"01\",\"operateMode\":\"02\",\"phoneModel\":\"华为\",\"cardOldBal\":24}";
        Gson gson = new Gson();
        Map<String,String> map = new HashMap<String, String>();

        map = gson.fromJson(jsonstr,new TypeToken<Map<String,String>>(){}.getType());
        System.out.println(map);
        System.out.println(Integer.toHexString(Integer.parseInt("18")+1));
        System.out.println("24".equals(Integer.parseInt("0018", 16) + ""));*/

    }
}

