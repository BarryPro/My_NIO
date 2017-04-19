package com.belong.others;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type A.
 */
public class PathsTest {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		Path listing=Paths.get("D:\\logs\\log.log");
		Path listing1=FileSystems.getDefault().getPath("D:\\logs\\log.log");
		System.out.println(listing1);
		System.out.println(listing.getFileName());
		System.out.println(listing.getNameCount());
		
		System.out.println(listing.getParent());
		System.out.println(listing.getRoot());
		//System.out.println(listing.subpath(2,3));
		//normalize():
		Path normalizedPath=Paths.get("D:\\logs\\log.log").normalize();
		System.out.println( normalizedPath);
		

		try {
			Path realPath=Paths.get("D:\\logs\\log.log").toRealPath();
			System.out.println( realPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path prefix=Paths.get("D:\\logs\\log.log");
		Path completePath=prefix.resolve("D:\\logs\\log.log");
		System.out.println(prefix.resolve(completePath));
	}
}
