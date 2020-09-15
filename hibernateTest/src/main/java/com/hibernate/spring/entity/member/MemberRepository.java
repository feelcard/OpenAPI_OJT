package com.hibernate.spring.entity.member;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

  Optional<Member> findByMemberName(String memberName);

  Optional<Member> findByMemberId(String memberId);

}
