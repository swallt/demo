package com.zhousx.mina.service;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class MinaTimeServer {

    public static void main(String[] args) throws IOException {
        //创建IoService的实例
        IoAcceptor acceptor = new NioSocketAcceptor();
        //设置过滤链 日志、编解码
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        //设置读取数据的缓冲区大小
        acceptor.getSessionConfig().setReadBufferSize(1024*102400);
        //读写通道10秒内无操作进入空闲状态
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        //设置处理器  业务逻辑处理的地方
        acceptor.setHandler(new TimeServerHandle());
        //配置监听端口
        acceptor.bind(new InetSocketAddress(9123));
    }
}
