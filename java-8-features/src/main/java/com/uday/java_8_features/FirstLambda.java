/**
 * 
 */
package com.uday.java_8_features;

import java.io.File;
import java.io.FileFilter;

/**
 * @author udaybhanuprasad
 *
 */
public class FirstLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileFilter fileFilter = pathName -> pathName.getName().endsWith(".java");
		File dir = new File("/Users/udaybhanuprasad/Desktop/Uday/Technology/Java/Spring/projects/java-8-features/src/main/java/com/uday/java_8_features/");
		File[] files = dir.listFiles(fileFilter);
		System.out.println("Listing java files");
		for(File file : files){
			System.out.println(file);
		}
	}

}
