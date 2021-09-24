package fr.htc.abre.corr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionnaire {

	List<Node> racines = new ArrayList<>();

	public Dictionnaire() {
		for (int i = 0; i < 26; i++) {
			racines.add(new Node(null, null));
		}
	}

	/**
	 * 
	 * @param file
	 */
	public void buildDico(File file) {
		try {
			BufferedReader b = new BufferedReader(new FileReader(file));
			String line = "";

			while ((line = b.readLine()) != null) {
				if(line != null ) {
					this.processWord(line);
				}
			}
			b.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processWord(String line) {
		char[] letters = line.toCharArray();

		char first = letters[0];
		Node node = this.addRacineIfNotExist(first);

		for (int i = 1; i < letters.length; i++) {
			node = node.process(letters[i]);
		}
		node.setWord(true);
	}

	private Node addRacineIfNotExist(char first) {
		int index = AlphabetOrder.getOrder(first);
		Node node =  this.racines.get(index);
		if ( node.getCar() ==  null) {
			node.setCar(first);
		}
		return node;
	}

	public boolean hasWord(String word) {
		char[] letters = word.toCharArray();
		char first = letters[0];
		Node node = this.racines.get(AlphabetOrder.getOrder(first));
		
		Node previous = null;
		int i = 1;
		do {
			previous = node;
			node = node.avancer(letters[i++]);
		}while(node != null);
		
		if(previous.isWord()) {
			return true;
		}
		return false;
	}

}
