package fr.htc.files;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	/**
	 * 
	 * @param pathdir
	 * @return
	 */
	public static List<File> getFileName(String pathdir) {

		File dir = new File(pathdir);

		if (dir.isFile())  return null;
		
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
	public static boolean isNumeric(String fileName) {
		int pointIndex = fileName.lastIndexOf(".");
		String lastChar = fileName.substring(pointIndex - 1, pointIndex);
		try {
			Integer.parseInt(lastChar);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	public static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {
		if(targetLocation.createNewFile()) {
			sourceLocation.delete();
		}
	}

	public static boolean isAlpha(String name) {
		return ! isNumeric(name);
	}

}
