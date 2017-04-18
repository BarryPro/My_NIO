package com.belong.others;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class J {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {        
        Path filePath = Paths.get("1.sql");  
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(filePath);  
        ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 1024);
        //futureDemo(afc, byteBuffer);
        afc.read(byteBuffer, 0, null, new CompletionHandler<Integer, Object>() {  
            @Override  
            public void completed(Integer result, Object attachment) {  
                System.out.println("Bytes Read = " + result);
            }  
  
            @Override  
            public void failed(Throwable exc, Object attachment) {  
                System.out.println(exc.getCause());
            }  
        });  
        System.out.println("Waiting for completion...");
        System.out.println("End");  
        afc.close();  
    }  
    private static void futureDemo(AsynchronousFileChannel afc, ByteBuffer byteBuffer) throws InterruptedException, ExecutionException, IOException {  
        Future<Integer> result = afc.read(byteBuffer, 0);  
        while (!result.isDone()) {  
            System.out.println("Waiting file channel finished....");  
            Thread.sleep(1000);  
        }  
        System.out.println("Finished? = " + result.isDone());  
        System.out.println("byteBuffer = " + result.get());  
        System.out.println(byteBuffer);  
        afc.close();  
    }  
}  
