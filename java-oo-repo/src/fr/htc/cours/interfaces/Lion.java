package fr.htc.cours.interfaces;

public class Lion extends Carnivore {

	@Override
	public void crier() {
		System.out.println(" Roah, Roaaar, Raaah! ");
	}

	@Override
	public void manger() {
		super.manger();
		System.out.println(" : 17 kg / jours");
	}

}
