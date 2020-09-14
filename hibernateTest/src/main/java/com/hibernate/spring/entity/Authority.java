package com.hibernate.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.hibernate.spring.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authority {
  @Id
  private String authCode;
  private String authName;
  private String authCreateBy;
  private String authCreateDate;
  private String authUpdateBy;
  private String authUpdateDate;
  private String authDelete;

  @OneToMany(mappedBy = "auth")
  Set<DisplayAuth> displayAuths = new HashSet<>();


  @OneToMany(mappedBy = "auth")
  Set<Member> members = new HashSet<>();
}
