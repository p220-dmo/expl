package fr.htc.cours.exemples.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileRead {

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();

		
		// Create link between physical file and java object : file
		FileReader file = new FileReader("data/file.txt");
		
		//Load file on buffer memory
		BufferedReader buffer = new BufferedReader(file);
		
		// Read all lines in List object
		List<String> lineList = buffer.lines().collect(Collectors.toList());
		
		//iterate over list and print lines 
		for (String aLine : lineList) {
			System.out.println(aLine);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println((double) duration / 1_000_000_000);
	}
}
