package fr.htc.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainClasse {

	private static final String PATH_DIR = "dir";
	private static final String BH_OM_DIR = "dir/num";
	private static final String BH_MELIM_DIR = "dir/alpha";
	private static final String ARCHIVE_DIR = "dir/alpha";

	public static void main(String[] args) throws IOException {

		List<File> fileNames = FileUtils.getFileName(PATH_DIR);

		for (File file : fileNames) {
			if (FileUtils.isBhOm(file.getName())) {
				FileUtils.copyFile(file, new File(BH_OM_DIR + "/" + file.getName()));
				continue;
			}
			if (FileUtils.isBhMelim(file.getName())) {
				FileUtils.copyFile(file, new File(BH_MELIM_DIR + "/" + file.getName()));
				continue;
			}
			//ICI traimenet des fichier qui ne respecte pas ces deux règles
			FileUtils.copyFile(file, new File(ARCHIVE_DIR + "/" + file.getName()));
		}

	}

}
