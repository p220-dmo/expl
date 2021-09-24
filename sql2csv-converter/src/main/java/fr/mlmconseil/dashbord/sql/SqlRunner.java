package fr.mlmconseil.dashbord.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.mlmconseil.dashbord.model.ResultSetWrapper;
import fr.mlmconseil.dashbord.model.SqlFileWrapper;

public class SqlRunner {
	final static Logger logger = Logger.getLogger(SqlRunner.class);
	private static Connection connection;

	/**
	 * 
	 * @param SqlFileWrapperList
	 * @return
	 */
	public static List<ResultSetWrapper> executeAll(List<SqlFileWrapper> SqlFileWrapperList) {

		if (checkConnection() == false) {
			logger.error("Unable to establish connection, program will exit");
			return null;
		}

		List<ResultSetWrapper> rsWrapperList = new ArrayList<ResultSetWrapper>();

		for (SqlFileWrapper sqlFileWrapper : SqlFileWrapperList) {
			ResultSetWrapper rsWrapper = new ResultSetWrapper(sqlFileWrapper.getFileName());

			rsWrapper.setResultSet(executeQuery(sqlFileWrapper.getSql()));

			rsWrapperList.add(rsWrapper);
		}

		return rsWrapperList;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	private static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

		} catch (SQLException sqle) {
			logger.error("Errors occurs when executing sql query : " + sql, sqle);
		}

		return rs;
	}

	private static boolean checkConnection() {
		try {
			connection = DBUtils.getConnection();
		} catch (SQLException e) {
			logger.error(e);
			return false;
		}
		return true;
	}

}
