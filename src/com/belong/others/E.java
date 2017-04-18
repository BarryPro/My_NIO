package com.belong.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class E {

	public static void main(String[] args) {
		simpleFile();
	}
	private static void simpleFile() {
		Path file=Paths.get("1.sql");
		try {
			List<String> lines=Files.readAllLines(file,StandardCharsets.UTF_8);
			byte[] bytes=Files.readAllBytes(file);
			System.out.println(new String(bytes,"utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void writeFile() {
		Path file=Paths.get("2.txt");
		try(BufferedWriter writer=Files.newBufferedWriter(file, 
				StandardCharsets.UTF_8,StandardOpenOption.WRITE)){
			//StandardOpenOption.READ StandardOpenOption.APPEND
			writer.write("Hello");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void readFile() {
		Path file=Paths.get("1.sql");
		
		try(BufferedReader reader=Files.newBufferedReader(file, StandardCharsets.UTF_8)){
			
			String line="";
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
