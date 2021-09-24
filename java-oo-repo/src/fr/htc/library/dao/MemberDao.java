package fr.htc.library.dao;

import java.util.Collection;

import fr.htc.library.entity.Member;

public interface MemberDao {

	Member save(Member member);

	Collection<Member> getAllMember();

	Member getMemberByMatricule(String matricule);

}
