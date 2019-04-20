package com.zhousx.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {  //1  声明泛型，只有msg为FullHttpRequest的消息才能进来

    private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception{
        System.out.println("class: " + msg.getClass().getName());
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer("test".getBytes())); //2 生成response

        HttpHeaders heads = response.headers();
        heads.add(HttpHeaderNames.CONTENT_TYPE,contentType + "; charset=UTF-8");
        heads.add(HttpHeaderNames.CONTENT_LENGTH,response.content().readableBytes()); //3添加header描述length。如果没有这一步，用postman发出请求吼就一直在刷新，因为http请求方不知道返回的数据有多长
        heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

        ctx.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
        System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
        ctx.flush(); //4 channel读取完成后需要输出到缓冲流，如果没有这一步，postman同样会一直刷新
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
        System.out.println("exceptionCaught");
        if (null != cause) cause.printStackTrace();
        if (null != ctx) ctx.close();
    }
}
