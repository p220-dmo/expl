package fr.htc.formation.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static private Connection conn = null;
	private static String url = "jdbc:postgresql://192.168.1.249:5432/big-data-db";
	// Database credentials
	private static String user = "postgres";
	private static String password = "admin@123";

	public static Connection getConnection() {


		try {
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
