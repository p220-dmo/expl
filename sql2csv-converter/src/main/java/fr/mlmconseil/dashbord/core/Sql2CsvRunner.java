package fr.mlmconseil.dashbord.core;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import fr.mlmconseil.dashbord.csv.CsvConverterWriter;
import fr.mlmconseil.dashbord.file.FileReader;
import fr.mlmconseil.dashbord.model.ResultSetWrapper;
import fr.mlmconseil.dashbord.model.SqlFileWrapper;
import fr.mlmconseil.dashbord.sql.SqlRunner;

public class Sql2CsvRunner {

	final static Logger logger = Logger.getLogger(Sql2CsvRunner.class);
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)  {
		//Charger la requêtre sql
		List<SqlFileWrapper> sqlFilesAsString = FileReader.readSqlFilesAsString();
		
		//Executer la requête
		List<ResultSetWrapper> resultSetWrapperList = SqlRunner.executeAll(sqlFilesAsString);
		
		//Convertir en CSV
		CsvConverterWriter.convertAndSave(resultSetWrapperList);
	}
}
