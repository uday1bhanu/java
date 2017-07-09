/**
 * 
 */
package com.uday.java_8_features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author udaybhanuprasad
 *
 */
public class IOExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(DateAndTime.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();
				){
			stream.filter(line -> line.contains("Uday"))
				  .findFirst()
				  .ifPresent(System.out::println);		
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		Path path = Paths.get("/Users/udaybhanuprasad/Desktop/Uday/Technology/Java/java/java-8-features/src/main/java/com/uday/java_8_features/people.txt");
		try(Stream<String> stream = Files.lines(path)){
			stream.filter(line -> line.contains("Uday"))
			      .findFirst()
			      .ifPresent(System.out::println);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		path = Paths.get("/Users/udaybhanuprasad/Desktop/Uday/Technology/Java/java/java-8-features/");
		try(Stream<Path> paths = Files.list(path)){
			paths.filter(p -> p.toFile().isDirectory())
			     .forEach(System.out::println);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		//walks through all the sub-directories with number of levels
		try(Stream<Path> paths = Files.walk(path, 2)){
			paths.filter(p -> p.toFile().isDirectory())
			     .forEach(System.out::println);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}
