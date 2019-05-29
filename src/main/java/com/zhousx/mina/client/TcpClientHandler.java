package com.zhousx.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TcpClientHandler extends IoHandlerAdapter {
    //会话创建时触发
    @Override
    public void sessionOpened(IoSession session)throws Exception{
        session.write("Hello...");
    }
    //接收到消息时触发
    @Override
    public void messageReceived(IoSession session,Object message) throws Exception{
        System.out.println("recever:"+message.toString());
        session.write("received: "+message.toString());
    }
}
