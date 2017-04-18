package com.belong.nio;

import java.nio.ByteBuffer;

/**
 * @Author: belong.
 * @Description: 为指定类型的缓冲区分配缓冲大小
 * @Date: 2017/4/18.
 */
public class BufferWrap {
    public void myMethod()
    {
        // 分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        // 包装一个现有的数组变成缓冲区
        byte array[] = new byte[10];
        ByteBuffer buffer2 = ByteBuffer.wrap( array );
    }
}
