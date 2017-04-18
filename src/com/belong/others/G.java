package com.belong.others;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class G {
	public static void main(String[] args) {
		writeData();
	}
	private static void writeData(){
		Path logFile=Paths.get("3.txt");
		final int BSIZE=1024;

		FileChannel fc=null;
		try {
			fc = FileChannel.open(logFile, StandardOpenOption.WRITE);

			fc.write(ByteBuffer.wrap("".getBytes()));

			fc.close();  

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void appendData(){
		FileChannel fc=null;
		try {
			fc = new RandomAccessFile("c:\\1.txt","rw").getChannel();
			fc.position(fc.size());

			fc.write(ByteBuffer.wrap("".getBytes()));

			fc.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readData() {
		Path logFile=Paths.get("1.sql");
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		try {
			FileChannel fc=FileChannel.open(logFile, StandardOpenOption.READ);
			fc.read(buffer,fc.size()-1000);
			buffer.flip();
			Charset  cs = Charset.forName("utf-8");
			System.out.println(cs.decode(buffer));
			fc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
