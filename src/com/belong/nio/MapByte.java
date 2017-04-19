package com.belong.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: belong.
 * @Description:
 * @Date: 2017/4/18.
 */
public class MapByte {
    static private final int start = 0;
    static private final int size = 1024;

    static public void main( String args[] ) throws Exception {
        RandomAccessFile raf = new RandomAccessFile( "D:\\logs\\tmp.txt", "rw" );
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,
                start, size );
        mbb.put( 0, (byte)97 );
        mbb.put( 1023, (byte)122 );
        System.out.println(mbb);
        raf.close();
    }
}
