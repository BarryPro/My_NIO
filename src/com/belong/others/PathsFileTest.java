package com.belong.others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import static java.nio.file.StandardCopyOption.*;

/**
 * The type C.
 */
public class PathsFileTest {
	/**
	 * Move file.
	 */
	public static void moveFile(){
		try {
			Path source=Paths.get("c://2.sql");
			Path target=Paths.get("c://1/3.sql");
			Files.move(source, target,REPLACE_EXISTING,ATOMIC_MOVE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Copy file.
	 */
	public static void copyFile(){
		try {
			Path source=Paths.get("c://22.sql");
			Path target=Paths.get("c://1/1.sql");
			Files.copy(source, target,REPLACE_EXISTING,COPY_ATTRIBUTES);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Del file.
	 */
	public static void delFile(){
		Path target=Paths.get("c://11.sql");
		try {
			Files.delete(target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create file.
	 */
	public static void createFile(){
		Path target=Paths.get("c://1.sql");
		try {
			Files.createFile(target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set attr.
	 */
	public static void setAttr(){
		Path target=Paths.get("c://1.sql");

		//Path file=Files.createFile(target);
		DosFileAttributeView view = Files.getFileAttributeView(target, DosFileAttributeView.class);  
		try {
			view.setReadOnly(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get attr.
	 */
	public static void getAttr(){
		Path path = Paths.get("c://1.sql");  
		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);  

		if (view != null) {  
			DosFileAttributes attrs=null;
			try {
				attrs = view.readAttributes();
			} catch (IOException e) {
				e.printStackTrace();
			}  
			System.out.println(attrs.isReadOnly());  
		}  
	}

	/**
	 * Set attr 1.
	 */
	public static void setAttr1(){
		try {

			Path path =  Paths.get("c://1.sql");
			System.out.println(":" +Files.getLastModifiedTime(path));
			PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class);
	        Set<PosixFilePermission> permissions = attrs.permissions();
			permissions.clear();
			permissions.add(PosixFilePermission.OWNER_WRITE);
			permissions.add(PosixFilePermission.OWNER_READ);
			permissions.add(PosixFilePermission.GROUP_READ);
			permissions.add(PosixFilePermission.OTHERS_READ);
			Files.setPosixFilePermissions(path, permissions);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		copyFile();
		
	}
}
