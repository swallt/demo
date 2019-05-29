package com.zhousx.mina.service;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class TimeServerHandle extends IoHandlerAdapter {

    //设置一个变量
    public static int count = 0;
    //当捕获到异常时会触发
    public void execptionCaught(IoSession session,Throwable cause) throws Exception{
        cause.printStackTrace();
    }

    //接收到数据时触发
    public void messageReceived(IoSession session, Object message){
        String mes = message.toString();
        //当接收到的数据是quit时或者用户请求大于2次关闭链接
        if (mes.trim().equalsIgnoreCase("quit")||count>2){
            System.out.println("exit...");
            session.write("exit...");
            session.close();
            return;
        }
        //向客户端回复一个当前时间
        Date date = new Date();
        session.write(date.toString());
        System.out.println("message write: "+mes);
        count++;
    }
}
