package com.hibernate.spring.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import com.hibernate.spring.entity.member.Member;
import com.hibernate.spring.entity.member.MemberRepository;

public class CustomUserDetaliService implements UserDetailsService {

  @Autowired
  MemberRepository memberRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String Id) throws UsernameNotFoundException {
    Member member = memberRepository.findbyId(Id).get(0);

    List<GrantedAuthority> authorities = buildUserAuthority(member.getAuth().getAuthCode());


    return null;


  }

  private Member buildUserForAuthentication(Member user, List<GrantedAuthority> authorities) {

    return new Member(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
  }

  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
    for (UserRole userRole : userRoles) {
      authorities.add(new SimpleGrantedAuthority(userRole.getUserRoleName()));
    }

    return authorities;
  }

}
