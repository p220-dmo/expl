package fr.htc.library.dao;

import java.util.Collection;

import fr.htc.library.entity.Book;

public class BookDaoImpl implements BookDao {
	
	
	@Override
	public Book save(Book book) {
		
		LibraryDatabase.getBookTable().put(book.getCote(), book);
		return LibraryDatabase.getBookTable().get(book.getCote());
	}
	
	@Override
	public Book getBookByCote(String cote) {
		
		Book findBook = LibraryDatabase.getBookTable().get(cote);
		
		return findBook;
	}
	
	
	public Collection<Book> getAllBook() {
		return LibraryDatabase.getBookTable().values();
	}
	
	
	public void delete(Book book) {
		this.delete(book.getCote());
	}
	
	public void delete(String cote) {
		LibraryDatabase.getBookTable().remove(cote);
	}
	
	
	

}
