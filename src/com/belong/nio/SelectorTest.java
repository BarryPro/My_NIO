package com.belong.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: Selector（选择器）是Java NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件
 * <p>因为FileChannel不能切换到非阻塞模式。而套接字通道都可以</p>
 * @Author: belong.
 * @Date: 2017/4/19.
 */
public class SelectorTest {
    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            // 设置端口
            channel.socket().bind(new InetSocketAddress(9999));
            Selector selector = Selector.open();
            channel.configureBlocking(false);
            /**
             *  四种注册方式，监听感兴趣的通道
             *  Connect：SelectionKey.OP_CONNECT
                Accept：SelectionKey.OP_ACCEPT
                Read ：SelectionKey.OP_READ
                Write：SelectionKey.OP_WRITE
                如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来
                int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
             */
            //SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
            while(true) {
                int readyChannels = selector.select();
                if(readyChannels == 0) continue;
                // 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，
                // 然后可以通过调用selector的selectedKeys()方法，
                // 访问“已选择键集（selected key set）”中的就绪通道
                Set selectedKeys = selector.selectedKeys();
                Iterator keyIterator = selectedKeys.iterator();
                while(keyIterator.hasNext()) {
                    // ready 集合是通道已经准备就绪的操作的集合
                    SelectionKey key = (SelectionKey) keyIterator.next();
                    if(key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
