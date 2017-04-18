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
        String infile = "c:\\test.txt";
        FileInputStream fin = new FileInputStream(infile);
        FileChannel fcin = fin.getChannel();

        String outfile = String.format("c:\\testcopy.txt");
        FileOutputStream fout = new FileOutputStream(outfile);
        FileChannel fcout = fout.getChannel();

        // 使用allocateDirect，而不是allocate
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            buffer.clear();

            int r = fcin.read(buffer);

            if (r == -1) {
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }
    }
}
