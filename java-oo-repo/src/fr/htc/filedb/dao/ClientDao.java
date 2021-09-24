package fr.htc.filedb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.htc.filedb.data.Client;
import fr.htc.filedb.jdbc.JDBCConnection;

public class ClientDao {

	public void save(Client client) {
		String sqlQuery = this.generateSqlQuery(client);

		try {
			
			Connection conn = JDBCConnection.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("error");
			e.printStackTrace();
		}

	}

	private String generateSqlQuery(Client client) {
		StringBuilder queryBuilder = new StringBuilder("INSERT INTO CLIENT VALUES (");
		queryBuilder.append(client.getId());
		queryBuilder.append(", '" + client.getPrenom() + "'");
		queryBuilder.append(", '" + client.getNom() + "'");
		queryBuilder.append(", '" + client.getVille() + "'");
		queryBuilder.append(",  " + client.getZipCode());
		queryBuilder.append(",  " + client.getPointFidelite());
		queryBuilder.append(");");
		String sqlInsertClient = queryBuilder.toString();
		System.out.println(sqlInsertClient);
		return sqlInsertClient;

	}

	public List<Client> findAll() {
		
		String sqlQuery = "SELECT * FROM CLIENT";
		List<Client> selectedClients = new ArrayList<Client>();

		try {
			
			Connection conn = JDBCConnection.getConnection();
			
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(sqlQuery);
			
			
			while (res.next()) {
				Client client = new Client();
				client.setId(res.getInt(1));
				client.setNom(res.getString(2));
				client.setPrenom(res.getString(3));
				client.setVille(res.getString(4));
				client.setZipCode(res.getInt(5));
				client.setPointFidelite(res.getInt(6));
				selectedClients.add(client);
			}
			
		} catch (SQLException e) {
			System.err.println("error");
			e.printStackTrace();
		}

		return selectedClients;
	}

}
