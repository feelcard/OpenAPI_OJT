package com.hibernate.spring.entity.member;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

  List<Member> findbyId(String Id);

  List<Member> findbyName(String Name);

}
