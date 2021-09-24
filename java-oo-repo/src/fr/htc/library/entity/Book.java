package fr.htc.library.entity;

public class Book {
	private static int cpt = 10;
	private String cote;
	private String title;
	private String author;
	private int editionYear;
	
	private Member borrower;

	public Book(String title, String author, int editionYear) {
		this.title = title;
		this.author = author;
		this.editionYear = editionYear;
		this.cote = generateCote();
	}

	private String generateCote() {
		String part1 = "XX";
		if (author != null) {
			part1 = author.substring(0, 2).toUpperCase();
		}
		String part2 = "XX";

		if (editionYear != 0) {
			part2 = ("" + editionYear).substring(2, 4);
		}

		return part1 + part2 + "-" + cpt++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(int editionYear) {
		this.editionYear = editionYear;
	}

	public String getCote() {
		return cote;
	}
	
	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [cote=");
		builder.append(cote);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", editionYear=");
		builder.append(editionYear);
		builder.append(", borrower=");
		builder.append(this.borrower != null ? this.borrower.getMatricule() : "------");
		builder.append("]");
		return builder.toString();
	}

	public boolean isAvailable() {
		if(this.borrower == null) {
			return true;
		}
		return false;
	}

}
