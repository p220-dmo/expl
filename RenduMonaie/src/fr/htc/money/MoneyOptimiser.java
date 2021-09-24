package fr.htc.money;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MoneyOptimiser {
	private static final int[] PIECES = { 200, 100, 50, 20, 10, 5, 2, 1 };

	public static void main(String[] args) {
		Double monnaie = new Double(0);

		System.out.println(monnaie);
		LinkedList<String> ll = new LinkedList<>();
		System.out.println(ll);
		
		List<Money> rendu = new ArrayList<Money>();
		Integer reste = (int) (monnaie * 100);
		int index = 0;
		int currentPiece;
		while (reste > 0) {
			currentPiece = PIECES[index];
			if(currentPiece > reste) {
				index ++;
				continue;
			}
			rendu.add(new Money(reste / currentPiece, currentPiece));
			reste = reste % currentPiece;
			index++;
		}
		printResult(rendu);
		
	}

	private static void printResult(List<Money> rendu) {

		for (Money money : rendu) {
			System.out.println(money.getNbPiece() + " pièce(s) de " + money.getPiece());

		}

	}

}
