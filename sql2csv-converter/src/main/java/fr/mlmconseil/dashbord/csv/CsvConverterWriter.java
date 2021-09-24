package fr.mlmconseil.dashbord.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.CSVWriter;

import fr.mlmconseil.dashbord.file.FileReader;
import fr.mlmconseil.dashbord.model.ResultSetWrapper;
import fr.mlmconseil.dashbord.utils.Constants;

public class CsvConverterWriter {
	private static final boolean INCLUDE_COLUMN_NAME = true;

	/**
	 * 
	 * @param resultSetWrapperList
	 * @return
	 */
	public static void convertAndSave(List<ResultSetWrapper> resultSetWrapperList) {
		if (resultSetWrapperList == null || resultSetWrapperList.isEmpty()) {
			return;
		}

		for (ResultSetWrapper resultSetWrapper : resultSetWrapperList) {

			convertResultSetToCsv(resultSetWrapper);

		}
	}

	/**
	 * 
	 * @param resultSet
	 * @param csvFile
	 * @return
	 */
	private static void convertResultSetToCsv(ResultSetWrapper resultSetWrapper) {

		try {
			final List<String> destinationFilePaths = FileReader.getOutputDirs(resultSetWrapper.getFileName());

			for (String destFilePath : destinationFilePaths) {

				CSVWriter writer = new CSVWriter(
						Files.newBufferedWriter(Paths.get(destFilePath), StandardCharsets.UTF_8),
						Constants.SEMICOLON_FILE_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER,
						CSVWriter.DEFAULT_LINE_END);

				writer.writeAll(resultSetWrapper.getResultSet(), INCLUDE_COLUMN_NAME);
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
