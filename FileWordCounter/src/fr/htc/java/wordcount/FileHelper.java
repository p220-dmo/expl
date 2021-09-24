package fr.htc.java.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {

	/**
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static List<String> readFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner input = new Scanner(file);

		List<String> words = new ArrayList<>();
		while (input.hasNext()) {
			words.add(input.next());
		}
		input.close();
		return words;
	}
}
