package com.belong.nio;

import java.nio.ByteBuffer;

/**
 * @Author: belong.
 * @Description: 缓冲区继续分子分区
 * @Date: 2017/4/18.
 */
public class Slice {
    static public void main(String args[]) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 缓冲区中的数据0-9
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }

        // 创建子缓冲区
        // 设置子缓冲区的开始的位置
        buffer.position(3);
        // 缓冲区的大小
        buffer.limit(7);
        // 开始分割子缓冲区
        ByteBuffer slice = buffer.slice();

        // 改变子缓冲区的内容
        for (int i = 0; i < slice.capacity(); ++i) {
            byte b = slice.get(i);
            b *= 10;
            slice.put(i, b);
        }

        // 设置当前的位置
        buffer.position(0);
        buffer.limit(buffer.capacity());

        // 从设置的位置进行遍历缓冲区
        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }
    }
}
