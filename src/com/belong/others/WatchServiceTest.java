package com.belong.others;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * The type F.
 */
public class WatchServiceTest {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		try {
			WatchService watcher=FileSystems.getDefault().newWatchService();
			Path dir=FileSystems.getDefault().getPath("c://");
			WatchKey key=dir.register(watcher, ENTRY_MODIFY);
			boolean shutdown=false;
			while(!shutdown){
				key=watcher.take();
				for(WatchEvent<?> event:key.pollEvents()){
					if(event.kind()==ENTRY_MODIFY){
						System.out.println("");
						
					}
					
				}
				key.reset();
				shutdown=true;
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
