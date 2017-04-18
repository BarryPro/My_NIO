package com.belong.others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class D {
	public static void main(String[] args) {
		
	}
	private static void fileAttribute() {
		try {
			Path zip = Paths.get("1.sql");
			System.out.println(zip.toAbsolutePath().toString());
			System.out.println(Files.getLastModifiedTime(zip));
			System.out.println(Files.size(zip));
			System.out.println(Files.isSymbolicLink(zip));
			System.out.println(Files.isDirectory(zip));
			System.out.println(Files.readAttributes(zip, "*"));
		} catch (IOException ex) {
			System.out.println("Exception" + ex.getMessage());
		}
	}
}
