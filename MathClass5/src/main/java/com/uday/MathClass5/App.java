package com.uday.MathClass5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import driver.Computation;

public class App {
		//Delimiter used in CSV file
		private static final String NEW_LINE_SEPARATOR = "\n";
		
		//CSV file header
		private static final Object [] FILE_HEADER = {"operation","input1","input2","input3","input4","input5","output"};
		
		public static void main(String[] args){
			String path = "/Users/udaybhanuprasad/Downloads/Calculator.log";
			writeCsvFile(path);
		}

		public static void writeCsvFile(String fileName) {
			double[] variables = new double[5];
			variables[0] = 7.1;
			Computation Computation1 = new Computation(Computation.operations.perimeter, variables);
			
			variables[1] = 3.4;
			//Create new Computation objects
			Computation Computation2 = new Computation(Computation.operations.addition, variables);
			Computation Computation3 = new Computation(Computation.operations.multiply, variables);
			Computation Computation4 = new Computation(Computation.operations.substraction, variables);
			variables[2] = 3.4;
			Computation Computation5 = new Computation(Computation.operations.linear, variables);
			variables[3] = 4.4;
			Computation Computation6 = new Computation(Computation.operations.parabola, variables);
			
			//Create a new list of Computation objects
			List<Computation> computations = new ArrayList<Computation>();
			computations.add(Computation1);
			
			computations.add(Computation2);
			computations.add(Computation3);
			computations.add(Computation4);
			computations.add(Computation5);
			computations.add(Computation6);
			
			FileWriter fileWriter = null;
			
			CSVPrinter csvFilePrinter = null;
			
			//Create the CSVFormat object with "\n" as a record delimiter
	        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
					
			try {
				
				//initialize FileWriter object
				fileWriter = new FileWriter(fileName);
				
				//initialize CSVPrinter object 
		        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
		        
		        //Create CSV file header
		        csvFilePrinter.printRecord(FILE_HEADER);
				
				//Write a new Computation object list to the CSV file
				for (Computation computation : computations) {
					List ComputationDataRecord = new ArrayList();
		            ComputationDataRecord.add(computation.operation);
		            for(double vairable : computation.variables){
		            	ComputationDataRecord.add(vairable);
		            }
		            ComputationDataRecord.add(computation.doWork());
		            csvFilePrinter.printRecord(ComputationDataRecord);
				}

				System.out.println("CSV file was created successfully !!!");
				
			} catch (Exception e) {
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
					csvFilePrinter.close();
				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
	                e.printStackTrace();
				}
			}
		}
}
