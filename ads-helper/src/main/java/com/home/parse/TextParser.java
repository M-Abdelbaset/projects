package com.home.parse;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextParser {

	public static void main(String[] args) {
		//new TextParser().getKeywords();

		new TextParser().getUnique("src/main/resources/modified.txt", "src/main/resources/final.txt");
	}
	
	void getUnique(String inputFile, String outputFile){

		try {
			FileInputStream data = new FileInputStream(inputFile);
			Scanner dataSc = new Scanner(data);
			
			Set<String> dataSet = new HashSet<>();
					
			while (dataSc.hasNextLine()) {
				dataSet.add(dataSc.nextLine());
			}
			
			
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter(outputFile));
				for(String val : dataSet) {
					out.write(val);
					out.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.close();
			}		
			
			dataSc.close();
			data.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getKeywords() {

		try {
			FileInputStream data = new FileInputStream("src/main/resources/data.txt");
			FileInputStream alt = new FileInputStream("src/main/resources/alt.txt");
	//		FileInputStream modified = new FileInputStream("src/main/resources/modified.txt");
			FileInputStream prefix = new FileInputStream("src/main/resources/prefix.txt");
			
			Scanner dataSc = new Scanner(data);
			Scanner altSc = new Scanner(alt);
//			Scanner modifiedSc = new Scanner(modified);
			Scanner prefixSc = new Scanner(prefix);
			
			Set<String> dataSet = new HashSet<>();
			Set<String> altSet = new HashSet<>();
			Set<String> prefixSet = new HashSet<>();
			
			while (altSc.hasNextLine()) {
				altSet.add(altSc.nextLine());
			}
			
			while (prefixSc.hasNextLine()) {
				prefixSet.add(prefixSc.nextLine());
			}
			
			while (dataSc.hasNextLine()) {
				dataSet.add(dataSc.nextLine());
			}
			
			Set<String> suffix = new HashSet<>();
			for(String altVal : altSet) {
				for(String prefixVal: prefixSet) {
					suffix.add(prefixVal + altVal);
				}
			}
			
			System.out.println(suffix);
			
			Set<String> modifiedSet = new HashSet<>();
			for(String dataVal : dataSet) {
				for(String suffixVal: suffix) {
					modifiedSet.add(dataVal + " " + suffixVal);
				}
			}
			
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("src/main/resources/modified.txt"));
				for(String val : modifiedSet) {
					out.write(val);
					out.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.close();
			}		
			
			dataSc.close(); altSc.close();  prefixSc.close();
			data.close(); alt.close(); prefix.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
