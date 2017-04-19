package com.belong.others;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type .
 */
public class AsynchronousFileChannelTest3 {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		AsynchronousFileChannel channel=null;
		try {
			Path file=Paths.get("1.sql");
			channel=AsynchronousFileChannel.open(file);
			ByteBuffer buffer=ByteBuffer.allocate(100_000);
			channel.read(buffer, 0,null,new CompletionHandler<Integer,Object>(){

				@Override
				public void completed(Integer result, Object attachment) {
					System.out.println("Success");
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					System.out.println(exc.getMessage());
				}
				
			});
			
//			channel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {  
//	            @Override  
//	            public void completed(Integer result, Object attachment) {  
//	                System.out.println("Bytes Read = " + result);  
//	             
//	            }  
//	  
//	            @Override  
//	            public void failed(Throwable exc, Object attachment) {  
//	                System.out.println(exc.getMessage());  
//	               
//	            }  
//	        });  
	        System.out.println("Waiting for completion...");
	        channel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
