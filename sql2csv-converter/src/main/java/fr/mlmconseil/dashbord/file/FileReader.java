package fr.mlmconseil.dashbord.file;

import static fr.mlmconseil.dashbord.utils.Constants.DEST_CONFIG_SEPARATOR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import fr.mlmconseil.dashbord.model.SqlFileWrapper;
import fr.mlmconseil.dashbord.utils.ConfigLoader;
import fr.mlmconseil.dashbord.utils.Constants;

public class FileReader {
	final static Logger logger = Logger.getLogger(FileReader.class);

	/**
	 * 
	 * @return
	 */
	public static List<SqlFileWrapper> readSqlFilesAsString() {
		final String inputDir = ConfigLoader.getParamByKey(Constants.DIR_SQL_INPUT);

		if (checkPath(inputDir) == false) {
			throw new IllegalStateException("The input path is modatory");
		}

		File inpuDir = new File(inputDir);

		if (checkDirectory(inpuDir) == false) {
			throw new IllegalStateException("Missing or invalid input directory");
		}
		List<File> sqlFiles = Arrays.asList(inpuDir.listFiles());
		List<SqlFileWrapper> sqlFileWrapperList = new ArrayList<SqlFileWrapper>();

		for (File file : sqlFiles) {
			SqlFileWrapper sqlFileWrapper = new SqlFileWrapper(file.getName());
			sqlFileWrapper.setSql(readFileAsString(file));
			sqlFileWrapperList.add(sqlFileWrapper);
		}

		return sqlFileWrapperList;
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	private static String readFileAsString(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			return new String(data, "UTF-8");

		} catch (FileNotFoundException fnfe) {
			logger.error("File not Exist, Error occurs when loading sql query from file : " + file.getPath(), fnfe);

		} catch (IOException ioe) {
			logger.error("Error occurs when loading sql query from file : " + file.getPath(), ioe);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "";
	}

	/**
	 * 
	 * @param inpuDir
	 * @return
	 */
	private static boolean checkDirectory(File inpuDir) {
		if (inpuDir == null || !inpuDir.exists() || inpuDir.isFile()) {
			logger.error("Input directory is not valid, please check your config file (\"dir.sql.input\")");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param inputDir
	 * @return
	 */
	private static boolean checkPath(final String inputDir) {
		if (inputDir == null || inputDir.isEmpty()) {
			logger.error("Input directory is mondatory, please check your config file (\"dir.sql.input\")");
			return false;
		}
		System.out;
		return true;
	}

	/**
	 * 
	 * @param csvFile
	 * @return
	 */
	public static List<String> getOutputDirs(String csvFile) {
		List<String> destKeyDirList = Arrays.asList(ConfigLoader.getParamByKey(csvFile).split(DEST_CONFIG_SEPARATOR));
		List<String> destFullPathList = new ArrayList<>();

		for (String destKeyDir : destKeyDirList) {
			StringBuilder sb = new StringBuilder(ConfigLoader.getParamByKey(destKeyDir));
			sb.append("/");
			sb.append(csvFile.replace("sql", "csv"));
			destFullPathList.add(sb.toString());
		}
		return destFullPathList;
	}

}
