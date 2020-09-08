package com.hibernate.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "FOURM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Forum {
  @Id
  private String forumId;
  private String forumField;
  private String forumTitle;
  private String forumCreateDate;
  private String forumCreateBy;
  private String forumUpdateDate;
  private String forumUpdateBy;

  @ManyToOne
  @JoinColumn(name = "member_id")
  // 내가 여러개고 다른대상이 1개 (이 객체를 불러올때 쿼리를쏜다)
  private Member member;



  @OneToMany(mappedBy = "forum")
  private Set<File> files = new HashSet<File>();

  @OneToMany(mappedBy = "forum")
  private Set<Reply> replys = new HashSet<Reply>();



  // void foo(){
  // member.getSubsi().getSubsiId();
  // }
  // }
}
