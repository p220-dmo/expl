package fr.htc.library.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.htc.library.dao.BookDao;
import fr.htc.library.dao.BookDaoImpl;
import fr.htc.library.dao.MemberDao;
import fr.htc.library.dao.MemberDaoImpl;
import fr.htc.library.entity.Book;
import fr.htc.library.entity.Member;
import fr.htc.library.services.CheckoutService;

public class CheckOutServiceImpl implements CheckoutService {
	
	private MemberDao memberDao = new MemberDaoImpl();
	private BookDao bookDao = new BookDaoImpl() ;

	@Override
	public boolean checkOut(String matricule, String cote) {
		if(checkNotProvided(matricule, cote)){
			return false;
		}
		
		Member member = checkExistMember(matricule);
		Book book = checkExistBook(cote);
		if(member == null || book == null){
			return false;
		}
		
		if(! member.canCheckout() ) {
			System.out.println("Member can't checkout, max book reached : " + Member.MAX_ALLOWED_BOOK);
			return false;
		}
		if(! book.isAvailable()) {
			System.out.println("Book ckecked out yet");
			return false;
		}
		
		member.addBook(book);
		book.setBorrower(member);
		return true;
	}

	private Book checkExistBook(String cote) {
		Book book;
		book = bookDao.getBookByCote(cote);
		if(book == null) {
			System.out.println("Book doesn't exist");
			return null;
		}
		return book;
	}

	private Member checkExistMember(String matricule) {
		Member member;
		member = memberDao.getMemberByMatricule(matricule);
		if(member == null) {
			System.out.println("Member doesn't exist");
			return null;
		}
		return member;
	}

	private boolean checkNotProvided(String matricule, String cote) {
		if(matricule == null || matricule.isEmpty()) {
			System.out.println("Operation  aborted, matricule must be provided");
			return true;
		}
		if(cote == null || cote.isEmpty()) {
			System.out.println("Operation aborted, cote must be provided");
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIn(String matricule, String cote) {
		if(checkNotProvided(matricule, cote)){
			return false;
		}
		Member member = checkExistMember(matricule);
		Book book = checkExistBook(cote);
		if(member == null || book == null){
			return false;
		}
		
		if(member.isBorrower(book)) {
			member.removeBook(book);
			book.setBorrower(null);
		}
		return true;
	}

	@Override
	public List<Book> findAvailableBooks() {
		List<Book> availableBooks = new ArrayList<Book>();
		
		for (Book book : bookDao.getAllBook()) {
			if(book.isAvailable()) {
				availableBooks.add(book);
			}
		}
		
		return availableBooks;
	}
	
	@Override
	public List<Book> findUnavailableBooks() {
	
		List<Book> availableBooks =  new ArrayList<>(bookDao.getAllBook()) ;
		availableBooks.removeAll(this.findAvailableBooks());
		return availableBooks;
	}

}
