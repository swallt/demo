package com.zhousx.demo;

import com.alibaba.dubbo.common.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.nio.charset.Charset;
import java.util.UUID;

public class HttpPostTest {

    public static void main(String[] args){

    }

    public static boolean httpPostWithJson(JSONObject jsonObject,String url,String appId){
        boolean isSuccess = false;

        HttpPost post = null;
        try{
            HttpClient httpClient = new DefaultHttpClient();

            //设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,2000);

            post = new HttpPost(url);
            //构造消息头
            post.setHeader("Content-type","application/json; charset=utf-8");
            post.setHeader("Connection","close");
            String sessionId = getSessionId();
            post.setHeader("SessionId",sessionId);
            post.setHeader("appid",appId);

            //构建消息实体
            StringEntity entity = new StringEntity(jsonObject.toString(),Charset.forName("utf-8"));
            entity.setContentEncoding("utf-8");
            //发送json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);

            //校验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                System.out.println("请求出错:" + statusCode);
                isSuccess = false;
            }else{
                int retCode = 0;
                String sessendId = "";
                //返回码包含retCode 和会话ID
                for (Header header: response.getAllHeaders()) {
                    if(header.getName().equals("retCode")){
                        retCode = Integer.parseInt(header.getValue());
                    }
                    if(header.getName().equals("SessionId")){
                        sessendId = header.getValue();
                    }
                }

                if (HttpStatus.SC_OK != retCode){
                    System.out.println("error return code,  sessionId: "+sessendId +"\t"+"retCode: "+retCode);
                    isSuccess = false;
                }else {
                    isSuccess = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            isSuccess = false;
        }finally {
            if(post != null){
                try{
                    post.releaseConnection();
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }

    public static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0,8)+str.substring(9,13)+str.substring(14,18)+str.substring(19,23)+str.substring(24);
    }
}
