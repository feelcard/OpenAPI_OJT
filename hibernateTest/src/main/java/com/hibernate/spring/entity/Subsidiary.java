package com.hibernate.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "SUBSIDIARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subsidiary {
  @Id
  @Column
  private String subsiId;
  @Column
  private String subsiName;
  @Column
  private String subsiCreateDate;
  @Column
  private String subsiUpdateBy;
  @Column
  private String subsiUpdateDate;
  @Column
  private String subsiDelete;

  @OneToMany(mappedBy = "subsi")
  Set<Member> members = new HashSet<Member>();


}
