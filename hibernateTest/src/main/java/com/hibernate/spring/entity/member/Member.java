package com.hibernate.spring.entity.member;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.hibernate.spring.entity.Authority;
import com.hibernate.spring.entity.Reply;
import com.hibernate.spring.entity.subsidiary.Subsidiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
  @Id
  @Column
  private String memberId;
  @Column
  private String memberPassword;
  @Column
  private String memberName;
  @Column
  private String memberCreateDate;
  @Column
  private String memberUpdateBy;
  @Column
  private String memberUpdateDate;
  @Column
  private String memberDelete;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_code")
  private Authority auth;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "subsi_id")
  private Subsidiary subsi;

  @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
  private Set<Reply> replys = new HashSet<Reply>();
}
