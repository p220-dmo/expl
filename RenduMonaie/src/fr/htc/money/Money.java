package fr.htc.money;

public class Money {
	private int nbPiece;
	private String piece;

	public Money(int nbPiece, int piece) {
		super();
		this.nbPiece = nbPiece;
		this.piece = findPiece(piece);
	}

	private String findPiece(int piece) {

		switch (piece) {
		case 200:
			return "2 Euros";
		case 100:
			return "1 Euro";
		case 50:
			return "50 Centimes";
		case 20:
			return "20 Centimes";
		case 10:
			return "10 Centimes";
		case 5:
			return "5 Centimes";
		case 2:
			return "2 Centimes";
		case 1:
			return "1 Centime";

		default:
			break;
		}
		return null;
	}

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public static void main(String[] args) {
		Integer[] TabPiece = { 200, 100, 50, 20, 10, 5, 2, 1 };
		String[] TabPieceafficher = { "2 euros", "1 euros", "50 centimes", "20 centimes", "10 centimes ", "5 centimes", "2 centimes", "1 centimes" };
		Integer arendre = Integer.valueOf(10);
		
		for (int i = 0; i < TabPiece.length; i++) {
			int nbPiece = arendre / TabPiece[i];
			arendre = arendre - (nbPiece * TabPiece[i]);
			if (nbPiece != 0) {
				System.out.println(nbPiece + " piéces de " + TabPieceafficher[i]);
			}
		}
	}

}
