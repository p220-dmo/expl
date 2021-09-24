package fr.htc.cours.interfaces;

public abstract class Carnivore implements Animal {

	public abstract void crier() ;

	@Override
	public void manger() {
		System.out.print("\nManger de la viande : ");

	}

}
