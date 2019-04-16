package com.zhousx.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class urlFileTest {
    public static void main(String[] args) throws Exception{
        String urlstr = "http://xcx-citytsm.oss-cn-hangzhou.aliyuncs.com/1552382577988-img.png";
        URL url = new URL("http://xcx-citytsm.oss-cn-hangzhou.aliyuncs.com/1552382577988-img.png");
        String filename = urlstr.substring(urlstr.lastIndexOf('/')+1);
        System.out.println(filename);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(3*1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        InputStream inputStream = conn.getInputStream();
        byte[] getData = readInputStream(inputStream);

        File saveDir = new File("E://");
        File file = new File(saveDir+File.separator+"1.png");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos!=null){
            fos.close();
        }
        if (inputStream!=null){
            inputStream.close();
        }


    }
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
