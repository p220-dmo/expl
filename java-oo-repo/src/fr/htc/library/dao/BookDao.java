package fr.htc.library.dao;

import java.util.Collection;

import fr.htc.library.entity.Book;

public interface BookDao {

	Book save(Book book);

	Book getBookByCote(String cote);

	Collection<Book> getAllBook();


}
