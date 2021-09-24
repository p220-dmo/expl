package fr.mlmconseil.dashbord.sql;

import static fr.mlmconseil.dashbord.utils.ConfigLoader.*;
import static fr.mlmconseil.dashbord.utils.Constants.DB_PWD_KEY;
import static fr.mlmconseil.dashbord.utils.Constants.DB_URL_KEY;
import static fr.mlmconseil.dashbord.utils.Constants.DB_USER_KEY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import fr.mlmconseil.dashbord.utils.Constants;

public class DBUtils {
	final static Logger logger = Logger.getLogger(DBUtils.class);
	private static Connection uniqueInstance ;

	public static Connection getConnection() throws SQLException {
		if(uniqueInstance == null) {
			uniqueInstance = DBUtils.createConnection();
		}
		return uniqueInstance;
	}

	private static Connection createConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName(Constants.JDBC_DRIVER);
			connection = DriverManager.getConnection(getParamByKey(DB_URL_KEY), getParamByKey(DB_USER_KEY), getParamByKey(DB_PWD_KEY));
		} catch (SQLException e) {
			logger.error("Error occurs when creating db connection", e);
			throw e;
		} catch (ClassNotFoundException cnfe) {
			logger.error("Please check that Postgres Driver available", cnfe);
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			uniqueInstance.close();
		} catch (SQLException e) {
			logger.error("unable to close connection", e);
		}
	}

}
