package fr.htc.library.dao;

import java.util.HashMap;
import java.util.Map;

import fr.htc.library.entity.Book;
import fr.htc.library.entity.Member;

public class LibraryDatabase {

	private static Map<String, Member> memberTable = new HashMap<String, Member>();
	private static Map<String, Book> bookTable = new HashMap<String, Book>();

	public static Map<String, Member> getMemberTable() {
		return memberTable;
	}

	public static Map<String, Book> getBookTable() {
		return bookTable;
	}

}
