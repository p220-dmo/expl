package fr.htc.library.services;

import java.util.List;

import fr.htc.library.entity.Book;

public interface BookService {

	Book save(String title, String author, int editionYear);

	List<Book> findAllBooks();

	Book getBookByCote(String cote);

}
