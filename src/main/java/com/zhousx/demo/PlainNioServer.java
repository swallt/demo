package com.zhousx.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket ss = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ss.bind(address);  //1
        Selector selector = Selector.open();        //2
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);      //3
        final ByteBuffer msg = ByteBuffer.wrap("hi\r\n".getBytes());
        for (;;){
            try {
                selector.select();   //4
            }catch (IOException e){
                e.printStackTrace();
                //handle exception
                break;
            }
            Set<SelectionKey> readkeys = selector.selectedKeys();   //5
            Iterator<SelectionKey> iterator = readkeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()){   //6
                        ServerSocketChannel server = (ServerSocketChannel)key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());   //7
                        System.out.println("Accepted connection from " + client);
                    }
                    if (key.isWritable()){          //8
                        SocketChannel clent = (SocketChannel)key.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        while (buffer.hasRemaining()){
                            if (clent.write(buffer) == 0){      //9
                                break;
                            }
                        }
                        clent.close();          //10
                    }
                } catch (IOException ex){
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e){
                        //ignore on close
                    }
                }
            }
        }
    }
}
