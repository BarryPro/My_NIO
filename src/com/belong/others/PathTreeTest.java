package com.belong.others;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * The type B.
 */
public class PathTreeTest {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		whileTree();
	}

	/**
	 * While tree.
	 */
	public static void whileTree(){
		Path startingDir=Paths.get("c:\\");
		try {
			Files.walkFileTree(startingDir, new FindJavaVisitior());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static class FindJavaVisitior extends SimpleFileVisitor<Path>{
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			if(file.toString().endsWith(".txt")){
				System.out.println(file.getFileName());

			}
			return FileVisitResult.CONTINUE;
		}


	}

	private static void findFile() {
		Path dir=Paths.get("c://");
		try (DirectoryStream<Path> stream=Files.newDirectoryStream(dir,"*.sql")){
			
			for(Path entry:stream){
				System.out.println(entry.getFileName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
