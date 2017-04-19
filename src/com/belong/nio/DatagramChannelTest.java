package com.belong.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Author: belong.
 * @Description: 大多用于网络的udp的数据传输,数据安全得不到保障
 * @Date: 2017/4/19.
 */
public class DatagramChannelTest {
    public static void main(String[] args) {
        DatagramChannel datagramChannel = null;
        try {
            // 打开数据管道
            datagramChannel = DatagramChannel.open();
            // 绑定关联的网址和端口号
            datagramChannel.connect(new InetSocketAddress("jenkov.com", 80));
            // 分配1k个字节的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 清空缓冲区
            byteBuffer.clear();
            while (byteBuffer.hasRemaining()) {
                int bytes = datagramChannel.read(byteBuffer);
                System.out.println(bytes);
                System.out.println(byteBuffer.toString());
            }
            // 关闭通道
            datagramChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
