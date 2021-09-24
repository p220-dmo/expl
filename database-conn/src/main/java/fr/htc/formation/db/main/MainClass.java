package fr.htc.formation.db.main;
import fr.htc.formation.db.dao.LivreDaoImpl;
import fr.htc.formation.db.entities.Livre;

public class MainClass {

	private static LivreDaoImpl livreDao = new LivreDaoImpl();

	public static void main(String[] args) {

		// insertion
		String auteur = "Med DIB";
		String titre = "Dar sbitar";
		int edition = 2010;
		Livre livre = new Livre(auteur, titre, edition);
		
		System.out.println("Creating book");
		 livreDao.create(livre);
		 
		 System.out.println("Consulting book...");
		 Livre foundBook = livreDao.read(livre.getCote());
		 System.out.println(foundBook);
		 
		 System.out.println("Deleting book, affected line(s) : " + livreDao.delete(livre.getCote()));
		 
		 

	}

}
