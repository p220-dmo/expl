package fr.htc.library.core;

import java.util.List;

import fr.htc.library.entity.Book;
import fr.htc.library.entity.Member;
import fr.htc.library.services.BookService;
import fr.htc.library.services.CheckoutService;
import fr.htc.library.services.MemberService;
import fr.htc.library.services.impl.BookServiceImpl;
import fr.htc.library.services.impl.CheckOutServiceImpl;
import fr.htc.library.services.impl.MemberServiceImpl;

public class MyLibraryLuncher {
	private static BookService bookService = new BookServiceImpl();
	private static MemberService memberService = new MemberServiceImpl();
	private static CheckoutService checkoutService = new CheckOutServiceImpl();

	static {
		initDatabase();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Coucou Kahina, j'ai toujours raison ;)");
		testSaveBook();
		testGetAllXXX();
		testCheckOut();
		testCheckIn();
		testAvailableBook();

	}

	private static void testAvailableBook() {
		final String matricule =  "RA100";
		final String cote1 =  "AU11-10";
		final String cote2 =  "EG11-11";
		final String cote3 =  "HA11-12";
		final String cote4 =  "IB11-13";
		
		List<Book> availableBooks = checkoutService.findAvailableBooks();
		System.out.println(availableBooks.size());
		System.out.println(checkoutService.findUnavailableBooks().size());
		
		System.out.println(checkoutService.checkOut(matricule, cote1));
		System.out.println(checkoutService.checkOut(matricule, cote2));
		
		availableBooks = checkoutService.findAvailableBooks();
		System.out.println(availableBooks.size());
		System.out.println(checkoutService.findUnavailableBooks().size());
		
		
		
		
	}

	private static void testCheckIn() {
		final String matricule =  "RA100";
		final String matricule2 =  "AH101";
		
		final String cote1 =  "AU11-10";
		System.out.println(checkoutService.checkOut(matricule, cote1));
		System.out.println(checkoutService.checkIn(matricule2, cote1));
		
		final String cote2 =  "EG11-11";
		System.out.println(checkoutService.checkOut(matricule, cote2));
		System.out.println(checkoutService.checkIn(matricule2, cote2));
		
		final String cote3 =  "HA11-12";
		System.out.println(checkoutService.checkOut(matricule, cote3));
		System.out.println(checkoutService.checkIn(matricule2, cote3));
		
		final String cote4 =  "IB11-13";
		System.out.println(checkoutService.checkOut(matricule, cote4));
		
		System.out.println(checkoutService.checkIn(matricule, cote1));
		
		System.out.println(checkoutService.checkOut(matricule, cote4));
		
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static void testCheckOut() {
		final String matricule =  "RA100";
		final String cote1 =  "AU11-10";
		
		Book book = bookService.getBookByCote(cote1);
		System.out.println(book);

		checkoutService.checkOut(matricule, cote1);
		System.out.println(memberService.getMemberByMatricule(matricule));
		
		
		
		final String cote2 =  "EG11-11";
		checkoutService.checkOut(matricule, cote2);
		System.out.println(memberService.getMemberByMatricule(matricule));
		final String cote3 =  "HA11-12";
		checkoutService.checkOut(matricule, cote3);
		
		System.out.println(memberService.getMemberByMatricule(matricule));
		
		final String cote4 =  "IB11-13";
		checkoutService.checkOut(matricule, cote4);
		
	}

	/**
	 * 
	 */
	private static void testGetAllXXX() {
		System.out.println("Voici la liste des livre enregistrés en base : ");
		List<Book> books = bookService.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
		
		
		System.out.println("Voici la liste des member enregistrés en base : ");
		List<Member> members = memberService.findAllMembers();
		for (Member member : members) {
			System.out.println(member);
		}
	}

	private static void initDatabase() {
		insertBookData();
		insertMemberData();
	}

	private static void insertMemberData() {
		
		memberService.save("Rébecca", "Armand", 24);
		memberService.save("Aimée", "Hebert", 36);
		memberService.save("Marielle", "Ribeiro", 27);
		memberService.save("Hilaire", "Savary", 58);
		memberService.save("Rébecca", "Armand", 24);
		memberService.save("Aimée", "Hebert", 36);
		memberService.save("Marielle", "Ribeiro", 27);
		memberService.save("Hilaire", "Savary", 58);
		memberService.save("Rébecca", "Armand", 24);
		memberService.save("Aimée", "Hebert", 36);
		memberService.save("Marielle", "Ribeiro", 27);
		memberService.save("Hilaire", "Savary", 58);
		memberService.save("Rébecca", "Armand", 24);
		memberService.save("Aimée", "Hebert", 12);
		memberService.save("Marielle", "Ribeiro", 27);
		memberService.save("Hilaire", "Savary", 58);
		memberService.save("Rébecca", "Armand", 24);

	}

	private static void insertBookData() { 
		bookService.save("Titre_200a", "Auteur_principal_qualificatif_700c", 2011); 
		bookService.save("L'eau des anges", "Egémar Béatrice", 2011); 
		bookService.save("Quand on parle du loup", "Harrison Lisi", 2011); 
		bookService.save("étang aux libellules (L')", "Ibbotson Eva", 2011); 
		bookService.save("Avant les ténèbres", "Cluzeau Nicolas", 2009);
		bookService.save("La boussole du Club des cinq", "Blyton Enid", 2009);
		bookService.save("Momo", "Ende Michael", 2011);
		bookService.save("Je m'appelle pas Ben Laden !", "Chambaz Bernard", 2011);
		bookService.save("Ogres, brigands et compagnie", "Ungerer Tomi", 2003);
		bookService.save("Gauchos de Patagonie", "Bourseiller Philippe", 2011);
		bookService.save("A minuit", "Mörike Eduard", 2011);
		bookService.save("Les cinq mènent l'enquête", "Voilier Claude", 2010);
		bookService.save("Jeanne", "Cassabois Jacques", 2004);
		bookService.save("Radio Nouba", "Bonneval Gwen de", 2007);
		bookService.save("Emile et les détectives", "Kästner Erich", 2004);
		bookService.save("On voyage", "Helft Claude", 2011);
		bookService.save("Nous les filles !", "Delmege Sarah", 2004);
		bookService.save("Radio Nouba", "Bonneval Gwen de", 2011);
		bookService.save("Nous les garçons !", "Crossick Matt", 2004);
		bookService.save("On prend des médicaments", "Helft Claude", 2004);
		bookService.save("Profession, pirate !", "Aubrun Claudine", 2004);
		bookService.save("La mer", "Bélineau Nathalie", 2004);
		bookService.save("La ligne de front", "Larcenet Manu", 2004);
		bookService.save("J'apprends à dessiner la vie quotidienne", "Legendre-Kvater Philippe", 2004);
		bookService.save("Collages de serviettes pour le jardin et la maison", "Enderlen-Debuisson Marie", 2003);
		bookService.save("Argile au tour", "Tardio-Brise Liliane", 2003);
		bookService.save("Petite histoire de la France au 20e siècle", "Prost Antoine", 2002);
		bookService.save("Les chevêches aux yeux d'or", "Haroux-Métayer Eliane", 2004);
		bookService.save("On rêve d'avoir un chat", "Helft Claude", 2004);
		bookService.save("Les grands explorateurs", "Platt Richard", 2004);
		bookService.save("Mythes et monstres", "Buller Laura", 2004);
		bookService.save("Les gladiateurs", "Malam John", 2015);
		bookService.save("Mirages", "Robillard Anne", 2013);
		bookService.save("ABC d'Albert Jacquard pour changer le monde (L')", "Jacquard Albert", 2014);
		bookService.save("arc-en-ciel des familles (L')", "Douru Muriel", 2015);
		bookService.save("I like Europe", "Gillet Caroline", 2010);
		bookService.save("fables de La Fontaine pour réfléchir (Les)", "Pelisse Laetitia", 1987);
		bookService.save("Vieux metiers et pratiques oubliees en Bourgogne, Nivernais-Morvan, autrefois",
				"Bertheau Georges", 2013);
		bookService.save("changelin (Le)", "Lindhom Per August", 2019);
		bookService.save("Meurtre au champagne", "Christie Agatha", 2005);
	}

	private static void testSaveBook() {
		// Test : Cas nominal : OK
		Book savedBook = bookService.save("Ce que le jour doit à la nuit", "Rachid", 2005);
		if (savedBook != null) {
			System.out.println("Book created successfully...");
		} else {
			System.out.println("Book not created yet...");
		}

		// Test : Cas title == null : KO
		Book savedBook2 = bookService.save(null, "Rachid", 2005);
		if (savedBook2 != null) {
			System.out.println("Book created successfully...");
		} else {
			System.out.println("Book not created yet...");
		}

		// Test : Cas title == null : KO
		Book savedBook3 = bookService.save("Ce que le jour doit à la nuit", null, 2005);
		if (savedBook3 != null) {
			System.out.println("Book created successfully...");
		} else {
			System.out.println("Book not created yet...");
		}

		// Test : Cas year = 0 : KO
		Book savedBook4 = bookService.save("Ce que le jour doit à la nuit", "Rachid", 1801);
		if (savedBook4 != null) {
			System.out.println("Book created successfully...");
		} else {
			System.out.println("Book not created yet...");
		}

	}

}
