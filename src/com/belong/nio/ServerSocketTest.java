package com.belong.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Description: ServerSocketChannel 是一个可以监听新进来的TCP连接的通道
 * @Author: belong.
 * @Date: 2017/4/19.
 */
public class ServerSocketTest {
    public static void main(String[] args) {
        try {
            // 打开服务套接通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置端口
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            // 设置非阻塞模式
            serverSocketChannel.configureBlocking(false);
            while(true){
                // accept()方法会一直阻塞到有新连接到达(监听新进来的链接)
                // accept() 方法会立刻返回，如果还没有新进来的连接，返回的将是null
                // 因此，需要检查返回的SocketChannel是否是null
                SocketChannel socketChannel =
                        serverSocketChannel.accept();
                if(!serverSocketChannel.isRegistered()){
                    break;
                }
                //do something with socketChannel...
            }
            serverSocketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
