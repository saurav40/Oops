package com.pratice.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileSorter {
	public static void main(String[] args) throws IOException {
      String input = "./input.txt";
      String output = "./output.txt";
      
      BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
      
      String line;
      while((line = bufferedReader.readLine()) != null) {
    	  System.out.println(line);
      }
      
      
      List<String> lines = Files.readAllLines(Paths.get(input));
      for(String line1 : lines) {
    	  System.out.println(line1);
      }
      
      Scanner scanner = new Scanner(new File(input));
      while(scanner.hasNextLine()) {
    	  System.out.println(scanner.nextLine());
      }
      
      List<String> lines2 = Files.lines(Paths.get(input)).collect(Collectors.toList());
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
      
      for(String line2 : lines) {
    	  bufferedWriter.write(line2);
    	  bufferedWriter.newLine();
      }
      System.out.println("Completed");
	}
}
