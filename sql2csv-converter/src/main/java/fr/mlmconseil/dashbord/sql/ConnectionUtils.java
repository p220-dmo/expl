package fr.mlmconseil.dashbord.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtils {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static private Connection conn = null;
	private static String url = "jdbc:postgresql://192.168.1.249:5432/postgres";
	// Database credentials
	private static String user = "postgres";
	private static String password = "postgres";

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
	
	
	public static void main(String[] args) {
		try {
			
			ResultSet rs = getConnection().createStatement().executeQuery("select * from emp");
			
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int salaire = rs.getInt("salaire");
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
