package com.zhousx.util;

import com.acquirer.util.MD5;
import com.acquirer.util.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MD5SignUtil {
    private final static Logger logger = LoggerFactory.getLogger(com.acquirer.util.MD5SignUtil.class);
    /**
     生成签名数据
     */
    public static String getPackageSignData(Map<String, String> mapParams, String keyValue, String charset, String... KeyName) {
        //排序
        Map<String,String> sortMap = MapUtil.sortMapByKey(mapParams);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : sortMap.entrySet()){
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            sb.append('&');
        }
        if(KeyName!=null){
            sb.append(KeyName[0]+"=");
        }else{
            sb.append("key=");
        }
        sb.append(keyValue);

        String packageSign = "";
        try {
            packageSign = MD5.getMessageDigest(sb.toString().getBytes(charset)).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return packageSign;
    }

    /**
     生成签名
     */
    public static String genPackageSign(Map<String, String> mapParams, String keyValue, String charset, String... KeyName) {
        //排序
        Map<String,String> sortMap = MapUtil.sortMapByKey(mapParams);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : sortMap.entrySet()){
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            sb.append('&');
        }
        if(KeyName.length>0){
            sb.append(KeyName[0]+"=");
        }else{
            sb.append("key=");
        }
        sb.append(keyValue);

        String packageSign = "";
        try {
            logger.debug("sign data="+sb.toString());
            packageSign = MD5.getMessageDigest(sb.toString().getBytes(charset)).toUpperCase();
            logger.debug("sign value="+packageSign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return packageSign;
    }
}