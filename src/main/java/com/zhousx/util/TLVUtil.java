package com.zhousx.util;

import com.zhousx.userbean.TLV;

import java.util.ArrayList;
import java.util.List;

public class TLVUtil {
    public List<TLV> tlvList;

    public TLVUtil(){
        tlvList = new ArrayList<TLV>();
    }

    public List<TLV> unpack(String tlv){
        int current = 0; //遍历tag标签
        int len = 0;
        int tagLen = 0;
        //将string转换成byte
        byte[] data = hexStrToByte(tlv);

        while (current < data.length){
            TLV tlvData = new TLV();
            tagLen =4;
            tlvData.setTag(getTagToInt(data,current,tagLen));

            current += tagLen;
            len = data[current]&0xFF;
            tlvData.setLen(len);

            byte[] temp = new byte[len];
            System.arraycopy(data,current,temp,0,len);
            tlvData.setValue(temp);

            current += len;
            tlvList.add(tlvData);
        }
        return tlvList;
    }

    public byte[] hexStrToByte(String data){
        if (data == null || "".equals(data)){
            return null;
        }
        int len = data.length()/2;
        byte[] result = new byte[len];
        //将每个char字符串单独转换成byte数据
        char[] chars = data.toCharArray();
        for (int i = 0; i < len; i++){
            int pos = i * 2;
            result[i] = (byte)(toByte(chars[pos]) << 4 | toByte(chars[pos +1 ]));
        }
        return result;
    }

    public static byte toByte(char c){
        byte b = (byte)"0123456789ABCDEF".indexOf(c);
        return b;
    }

    public int getTagToInt(byte[] data,int flag,int len){
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        len = Math.min(len,4);
        for (int i = 0; i< len;i ++){
            result <<=8;
            temp = data[flag+i]&mask;
            result |= temp;
        }
        return result;
    }

    private static char[] HEX_VOCABLE = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String bytesToHex(byte[] data){
        StringBuilder sb = new StringBuilder();
        for (byte b : data){
            int high = (b >> 4)& 0x0f;
            int low = b & 0x0f;
            sb.append(HEX_VOCABLE[high]);
            sb.append(HEX_VOCABLE[low]);
        }
        return sb.toString();
    }
}