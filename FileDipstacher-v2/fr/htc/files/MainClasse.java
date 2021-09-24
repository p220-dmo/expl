package fr.htc.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainClasse {

	private static final String PATH_DIR = "dir";
	private static final String NUM_DIR = "dir/num";
	private static final String ALPHA_DIR = "dir/alpha";

	public static void main(String[] args) throws IOException {

		List<File> fileNames = FileUtils.getFileName(PATH_DIR);

		for (File file : fileNames) {
			if (FileUtils.isNumeric(file.getName())) {
				FileUtils.copyDirectory(file, new File(NUM_DIR + "/" + file.getName()));
				continue;
			}
			if (FileUtils.isAlpha(file.getName())) {
				FileUtils.copyDirectory(file, new File(ALPHA_DIR + "/" + file.getName()));
				continue;
			}
		}

	}

}
