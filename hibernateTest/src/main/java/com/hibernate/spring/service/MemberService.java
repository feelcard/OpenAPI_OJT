package com.hibernate.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.hibernate.spring.entity.member.Member;
import com.hibernate.spring.entity.member.MemberRepository;

@Service
public class MemberService implements UserDetailsService {

  @Autowired
  MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Member> memberEntityWrapper = memberRepository.findByMemberId(username);
    Member memberEntity = memberEntityWrapper.orElse(null);
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

    return new User(memberEntity.getMemberId(), memberEntity.getMemberPassword(), authorities);
  }

  @Transactional
  public String save(Member memberTO) {
    Member member = memberTO;
    member.setMemberCreateDate(LocalDateTime.now().toString());

    // 비밀번호 암호화
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
    return memberRepository.save(member).getMemberId();
  }

}
