package fr.htc.java.wordcount;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordCounter {

	public static void main(String[] args) {
		final String path = args[0];

		try {
			List<String> words = FileHelper.readFile(path);

			Collections.sort(words);
			
			List<String> uniqueWordList = new ArrayList<>();
			List<Integer> occurenceWordList = new ArrayList<>();
			
			String preview = "";
			String current = "";
			
			preview = words.get(0);
			uniqueWordList.add(preview);
			occurenceWordList.add(Integer.valueOf(1));
			
			for(int i = 1; i<words.size(); i++) {
				
				current = words.get(i);
				while(preview.equals(current)) {
					
				}
				
				
				
				preview = current;
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
