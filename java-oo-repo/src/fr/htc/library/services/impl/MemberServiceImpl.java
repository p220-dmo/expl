package fr.htc.library.services.impl;

import java.util.ArrayList;
import java.util.List;

import fr.htc.library.dao.BookDaoImpl;
import fr.htc.library.dao.MemberDao;
import fr.htc.library.dao.MemberDaoImpl;
import fr.htc.library.entity.Book;
import fr.htc.library.entity.Member;
import fr.htc.library.services.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Member save(String nom, String prenom, int age) {
		if (nom == null) {
			System.out.println("Save Member aborted : name is mandatory!!! : " + nom);
			return null;
		}
		if (prenom == null) {
			System.out.println("Save Member aborted : first name is mandatory!!! : " + prenom);
			return null;
		}

		//Arrivée ici: je peut enfin créer un adhérent
		Member member = new Member(nom, prenom, age);
		
		Member savedMember = memberDao.save(member);
				
		return savedMember;
	}

	@Override
	public List<Member> findAllMembers() {
		List<Member> memberList = new ArrayList<Member>(memberDao.getAllMember());
		return memberList;
	}

	@Override
	public List<Book> getCheckedOutBook(String matricule) {
		return new ArrayList(memberDao.getMemberByMatricule(matricule).getCheckedOutBooks());
	}

	@Override
	public Member getMemberByMatricule(String matricule) {
		
		return memberDao.getMemberByMatricule(matricule);
	}

}







































