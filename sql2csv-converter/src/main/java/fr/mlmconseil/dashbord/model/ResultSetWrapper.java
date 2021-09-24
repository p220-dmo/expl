package fr.mlmconseil.dashbord.model;

import java.sql.ResultSet;

public class ResultSetWrapper {

	private ResultSet resultSet;
	private String fileName;

	public ResultSetWrapper() {
	}

	public ResultSetWrapper(String fileName) {
		this.fileName = fileName;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
