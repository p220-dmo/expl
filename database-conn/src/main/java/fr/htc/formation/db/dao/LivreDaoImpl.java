package fr.htc.formation.db.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.htc.formation.db.entities.Livre;
import fr.htc.formation.db.utils.ConnectionUtils;

public class LivreDaoImpl {
	Connection conn =  ConnectionUtils.getConnection();

	public void create(Livre livre) {
		try {
			Statement statmnt = conn.createStatement();
			String sqlQuery = "INSERT INTO LIVRE VALUES ('" + livre.getCote() + "','" + livre.getTitre() + "','"
					+ livre.getAuteur() + "'," + livre.getEdition() + ")";
			
			int status = statmnt.executeUpdate(sqlQuery);
			if (status > 0) {
				System.out.println("Livre created Succefully !!!" + status + "line(s) affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Livre read(String cote) {
		
		Livre livre = new Livre(cote);
		
		try {
			Statement statmnt = conn.createStatement();
		
			String sqlQuery = "SELECT * FROM LIVRE WHERE COTE = '" + cote + "'";
			
			ResultSet resultSet = statmnt.executeQuery(sqlQuery);
			
			 while (resultSet.next()) {
				 livre.setTitre(resultSet.getString("titre"));
				 livre.setAuteur(resultSet.getString("auteur"));
				 livre.setEdition(resultSet.getInt("edition"));
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return livre;
	}

	public int delete(String cote) {
		
		try {
			return conn.createStatement().executeUpdate("delete from LIVRE where cote = '" + cote + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

}
