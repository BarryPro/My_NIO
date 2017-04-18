package com.belong.nio;

import java.nio.ByteBuffer;

/**
 * @Author: belong.
 * @Description: 把普通的缓冲区转换成只读的缓冲区，只读和源缓冲区共享数据
 * @Date: 2017/4/18.
 */
public class OnlyReadBuffer {
    static public void main(String args[]) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 缓冲区中的数据0-9
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }

        // 创建只读缓冲区
        ByteBuffer readonly = buffer.asReadOnlyBuffer();

        // 改变原缓冲区的内容
        for (int i = 0; i < buffer.capacity(); ++i) {
            byte b = buffer.get(i);
            b *= 10;
            buffer.put(i, b);
        }

        readonly.position(0);
        readonly.limit(buffer.capacity());

        // 只读缓冲区的内容也随之改变
        while (readonly.remaining() > 0) {
            System.out.println(readonly.get());
        }
    }
}
