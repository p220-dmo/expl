package fr.mlmconseil.dashbord.model;

public class SqlFileWrapper {

	private String sql;
	private String fileName;

	public SqlFileWrapper() {
	}

	public SqlFileWrapper(String fileName) {
		this.fileName = fileName;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "SqlFileWrapper [fileName= " + fileName + "]\n sql=" + sql.replaceAll("\n", " ").replaceAll("\r", " ")  + "]";
	}
	
	

}
