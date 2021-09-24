package fr.htc.cours.interfaces;

public interface Animal {
	public abstract void crier();
	public abstract void manger();
	
	
	public default void defaultMethode() {
		System.out.println("Je suis la methode par default implémentée dans l'interface !!");
	}

}
