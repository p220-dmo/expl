package fr.htc.filedb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	private static Connection uniqueInstance = null;

	public static Connection getConnection() throws SQLException {
		if (uniqueInstance == null) {
			String url = "jdbc:postgresql://localhost:5432/postgres";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "admin");
			uniqueInstance = DriverManager.getConnection(url, props);
		}
		System.out.println(uniqueInstance);
		return uniqueInstance;

	}

}
