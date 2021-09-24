package fr.htc.formation.db.entities;

import java.util.ArrayList;
import java.util.List;

public class Adherent {
	private static int compteur = 100;

	private String matricule;
	private String nom;
	private String prenom;
	private int age;
	
	List<Livre> listEmprunt = new ArrayList<Livre>();


	public Adherent(String nom, String prenom, int age) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.age = age;
		this.matricule = generateMatricule();
	}

	private String generateMatricule() {
		return (this.nom.substring(0, 1) + this.prenom.substring(0, 1)).toUpperCase() + "-"+ compteur++ ;
	}

	public static int getCompteur() {
		return compteur;
	}
	public static void setCompteur(int compteur) {
		Adherent.compteur = compteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMatricule() {
		return matricule;
	}

//	@Override
//	public String toString() {
//		return "Adherent [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
//				+ ", listEmprunt=" + listEmprunt + "]";
//	}

	public boolean canCheckout() {
		if(listEmprunt.size() < 3) {
			return true;
		}
		System.out.println("Maximum checked out book attempted");
		return false;
	}

	public void addLivre(Livre livre) {
		listEmprunt.add(livre);
		
	}

	public void removeLivre(Livre livre) {
		listEmprunt.remove(livre);
	}
	


}
