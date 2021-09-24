package fr.htc.batch.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.htc.batch.data.Client;
import fr.htc.batch.jdbc.JDBCConnection;

public class ClientDao {

	public void save(Client client) {
		String sqlQuery = this.generateSqlQuery(client);

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(sqlQuery);
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

		return queryBuilder.toString();

	}

}
