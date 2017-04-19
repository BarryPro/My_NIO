package com.belong.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: belong.
 * @Description: 直接分配缓冲区
 * @Date: 2017/4/18.
 */
public class AllocateDirect {
    static public void main(String args[]) throws Exception {
        String infile = "D:\\logs\\tmp.txt";
        FileInputStream fin = new FileInputStream(infile);
        FileChannel fcin = fin.getChannel();

        String outfile = String.format("D:\\logs\\belong3.log");
        FileOutputStream fout = new FileOutputStream(outfile);
        FileChannel fcout = fout.getChannel();

        // 使用allocateDirect，而不是allocate
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            // 先清空缓存
            buffer.clear();
            // 把信息从通道读出放到缓冲区
            int r = fcin.read(buffer);
            // 当通道中没有数据就会返回-1
            if (r == -1) {
                break;
            }
            // 反转缓冲区
            buffer.flip();
            // 把缓冲区的内容写到输出通道
            fcout.write(buffer);
        }
        fcout.close();
        fcin.close();
    }
}
