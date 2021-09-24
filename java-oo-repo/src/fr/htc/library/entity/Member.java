package fr.htc.library.entity;

import java.util.HashSet;
import java.util.Set;

public class Member {

	public static final short MAX_ALLOWED_BOOK = 3;

	private static int cpt = 100;
	private String matricule;
	private String nom;
	private String prenom;
	private int age;

	private Set<Book> checkedOutBooks = new HashSet<Book>();

	public Member(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.matricule = generateMatricule();
	}

	private String generateMatricule() {
		return (nom.substring(0, 1) + prenom.substring(0, 1)).toUpperCase() + cpt++;
	}

	public boolean canCheckout() {
		if (this.checkedOutBooks.size() < MAX_ALLOWED_BOOK) {
			return true;
		}
		return false;
	}

	public void addBook(Book book) {
		this.checkedOutBooks.add(book);
	}

	public void removeBook(Book book) {
		this.checkedOutBooks.remove(book);
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

	public Set<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [matricule=");
		builder.append(matricule);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		
		for (Book book : checkedOutBooks) {
			builder.append("\n\t - " + book );
		}
		return builder.toString();
	}

	public boolean isBorrower(Book bookToBoorow) {
		for (Book book : checkedOutBooks) {
			if(book.equals(bookToBoorow)){
				return true;
			}
		}
		System.out.println("Member is not a borrower...");
		return false;
	}
	

}
