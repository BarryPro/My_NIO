package com.belong.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Description: Pipe是两个线程单向数据连接,传输的都是字节
 * @Author: belong.
 * @Date: 2017/4/19.
 */
public class PipeTest {
    public static void main(String[] args) {
        try {
            String newData = "New String to write to file..." + System.currentTimeMillis();
            // 打开通道
            Pipe pipe = Pipe.open();
            // 得到写通道
            Pipe.SinkChannel sinkChannel = pipe.sink();
            ByteBuffer buf_w = ByteBuffer.allocate(48);
            buf_w.clear();
            buf_w.put(newData.getBytes());
            buf_w.flip();
            while (buf_w.hasRemaining()) {
                sinkChannel.write(buf_w);

                System.out.println((char)buf_w.get(buf_w.position()));
            }

            // 得到读的通道
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buf_r = ByteBuffer.allocate(48);
            int bytesRead = sourceChannel.read(buf_r);
            System.out.println(bytesRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
