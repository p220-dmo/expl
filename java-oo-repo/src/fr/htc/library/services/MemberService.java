package fr.htc.library.services;

import java.util.List;

import fr.htc.library.entity.Book;
import fr.htc.library.entity.Member;

public interface MemberService {

	Member save(String nom, String prenom, int age);

	List<Member> findAllMembers();

	List<Book> getCheckedOutBook(String matricule);

	Member getMemberByMatricule(String matricule);

}
