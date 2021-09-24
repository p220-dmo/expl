package fr.htc.formation.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	public static void main(String[] args) throws IOException {
		
		File file = new File("file.txt");
		
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		fileOutputStream.write(5);
		
		file.createNewFile();

	}

}
