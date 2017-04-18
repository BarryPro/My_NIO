package com.belong.others;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

public class H {

	public static void main(String[] args) {
		try {

			Path file=Paths.get("d://video//1023///1.wmv");
			AsynchronousFileChannel channel=AsynchronousFileChannel.open(file);
			ByteBuffer buffer=ByteBuffer.allocate(1024*1024*10);
			Future<Integer> result=channel.read(buffer, 0);
			while(!result.isDone()){
				System.out.println("");
			}
			Integer bytesRead=result.get();
			System.out.println("read:["+bytesRead+"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
