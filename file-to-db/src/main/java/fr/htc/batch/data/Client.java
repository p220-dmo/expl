package fr.htc.batch.data;

import org.apache.commons.lang3.StringUtils;

public class Client {
	private int id;
	private String prenom;
	private String nom;
	private String ville;
	private int zipCode;
	private int pointFidelite;

	public static Client parseLine(String csvLine) {
		Client client = new Client();
		String[] tokens = StringUtils.split(csvLine, ";");

		client.setId(Integer.parseInt(tokens[0]));
		client.setPrenom(StringUtils.split(tokens[1], " ")[0]);
		client.setNom(StringUtils.split(tokens[1], " ")[1]);
		client.setVille(tokens[2]);
		client.setZipCode(Integer.parseInt(tokens[3]));
		client.setPointFidelite(Integer.parseInt(tokens[4]));

		return client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getPointFidelite() {
		return pointFidelite;
	}

	public void setPointFidelite(int pointFidelite) {
		this.pointFidelite = pointFidelite;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", ville=" + ville + ", zipCode=" + zipCode
				+ ", pointFidelite=" + pointFidelite + "]";
	}

	
}
