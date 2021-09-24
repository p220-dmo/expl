package fr.htc.library.services.impl;

import java.util.ArrayList;
import java.util.List;

import fr.htc.library.dao.BookDao;
import fr.htc.library.dao.BookDaoImpl;
import fr.htc.library.entity.Book;
import fr.htc.library.services.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();

	@Override
	public Book save(String title, String author, int editionYear) {
		if (title == null) {
			System.out.println("Save book aborted : Title is mandatory!!! : " + title);
			return null;
		}
		if (author == null) {
			System.out.println("Save book aborted : Author is mandatory!!! : " + author);
			return null;
		}
		if (editionYear < 1800) {
			System.out.println("Save book aborted : Edition year is mandatory!!! : " + editionYear);
			return null;
		}
		//Arrivée ici: je peut enfin créer un livre
		Book book = new Book(title, author, editionYear);
		
		Book savedBook = bookDao.save(book);
				
		return savedBook;
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> bookList = new ArrayList<Book>(bookDao.getAllBook());
		return bookList;
	}

	@Override
	public Book getBookByCote(String cote) {
		return bookDao.getBookByCote(cote);
	}

}
