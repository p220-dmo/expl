package fr.htc.cours.interfaces;

public class Zoo {

	public static void main(String[] args) {
		
		Animal lion1 	= new Lion();
		lion1.manger();
		Carnivore lion2 = new Lion();
		lion2.manger();
		Lion lion3      = new Lion();
		lion3.manger();
		
		
		lion1.defaultMethode();
		

	}

}
