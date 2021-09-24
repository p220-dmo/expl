package fr.htc.library.services;

import java.util.List;

import fr.htc.library.entity.Book;

public interface CheckoutService {
	
	boolean checkOut(String matricule, String cote);

	boolean checkIn(String matricule, String cote);

	List<Book> findAvailableBooks();

	List<Book> findUnavailableBooks();

}
