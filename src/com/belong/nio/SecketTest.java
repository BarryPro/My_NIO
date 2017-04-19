package com.belong.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description: <p>打开一个SocketChannel并连接到互联网上的某台服务器。
 * 一个新连接到达ServerSocketChannel时，会创建一个SocketChannel</p>
 * @Author: belong.
 * @Date: 2017/4/19.
 */
public class SecketTest {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            // 设置链接的网址和端口（套接字）
            socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));
            while(! socketChannel.finishConnect() ){
                //wait, or do something else...
            }
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = socketChannel.read(buf);
            System.out.println(bytesRead);
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
