package fr.htc.abre.corr;

import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		final String dicoPath = "dico.txt";

		Dictionnaire dico = new Dictionnaire();
		dico.buildDico(new File(dicoPath));

		
		String word = "ame";
		
		System.out.println(dico.hasWord(word));


	}

}
