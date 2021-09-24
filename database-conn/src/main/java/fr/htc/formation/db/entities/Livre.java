package fr.htc.formation.db.entities;

public class Livre {
	private static int compteur = 10;
	private String cote;
	private String titre;
	private String auteur;
	private int edition;
	
	private Adherent emprunteur;

	public Livre(String auteur, String titre, int edition) {
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.cote = generateCote();
	}

	public Livre(String cote) {
		this.cote  = cote;
	}

	private String generateCote() {
		return auteur.substring(0, 2).toUpperCase() + (edition + "").substring(2, 4) + "-" + compteur++;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getCote() {
		return cote;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}



	@Override
	public String toString() {
		return "Livre [cote=" + cote + ", titre=" + titre + ", auteur=" + auteur + ", edition=" + edition
				+ ", emprunteur=" + (emprunteur == null ? "" : emprunteur.getMatricule()) + "]";
	}

	public boolean available() {
		if(emprunteur == null) {
			return true;
		}
		System.out.println("Book (" + this.cote + ") are not available");
		return false;
	}
	
	

}
