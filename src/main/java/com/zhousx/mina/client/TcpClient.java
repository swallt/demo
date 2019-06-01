package com.zhousx.mina.client;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class TcpClient {
    public static void main(String[] args) {
        //创建IoService实例
        NioSocketConnector connector = new NioSocketConnector();
        //设置过滤链
        connector.getFilterChain().addLast("logger",new LoggingFilter());
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        //设置处理器
        connector.setHandler(new TcpClientHandler());
        //链接地址
        ConnectFuture connectFuture = connector.connect(new InetSocketAddress("localhost",9123));
    }
}
