package fr.htc.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public void process(String dir, String bhOmDir, String bhMelimDir, String archiveDir) {
		List<File> fileNames = FileUtils.getFileName(dir);

		try {
			for (File file : fileNames) {
				if (FileUtils.isBhOm(file.getName())) {
					FileUtils.copyFile(file, new File(bhOmDir + "/" + file.getName()));
					continue;
				}
				if (FileUtils.isBhMelim(file.getName())) {
					FileUtils.copyFile(file, new File(bhMelimDir + "/" + file.getName()));
					continue;
				}
				// ICI traimenet des fichier qui ne respecte pas ces deux règles
				FileUtils.copyFile(file, new File(archiveDir + "/" + file.getName()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param pathdir
	 * @return
	 */
	public static List<File> getFileName(String pathdir) {

		File dir = new File(pathdir);

		if (dir.isFile())
			return null;

		List<File> files = new ArrayList<>();
		for (File aFile : dir.listFiles()) {
			if (aFile.isFile()) {
				files.add(aFile);
			}
		}
		return files;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isBhOm(String fileName) {

		if (fileName.contains("BH_OM")) {
			return true;
		}
		return false;
	}

	public static void copyFile(File sourceLocation, File targetLocation) throws IOException {
		if (targetLocation.createNewFile()) {
			sourceLocation.delete();
		}
	}

	public static boolean isBhMelim(String fileName) {
		if (fileName.contains("BH_MELIM")) {
			return true;
		}
		return false;
	}

}
